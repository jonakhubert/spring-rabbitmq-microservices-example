package com.mycompany.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mycompany.employee.EmployeeDTO;
import com.mycompany.rabbitmq.TaskNotificationSender;
import com.mycompany.taskdetail.TaskDetail;
import com.mycompany.taskdetail.TaskDetailService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDTOMapper taskDTOMapper;
    private final RestClient restClient;
    private final TaskDetailService taskDetailService;
    private final TaskNotificationSender taskNotificationSender;

    public TaskServiceImpl(TaskRepository taskRepository, TaskDTOMapper taskDTOMapper, RestClient restClient,
                           TaskDetailService taskDetailService, TaskNotificationSender taskNotificationSender
    ) {
        this.taskRepository = taskRepository;
        this.taskDTOMapper = taskDTOMapper;
        this.restClient = restClient;
        this.taskDetailService = taskDetailService;
        this.taskNotificationSender = taskNotificationSender;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(taskDTOMapper).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(int id) {
        return taskRepository.findById(id).map(taskDTOMapper)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public void saveTask(Task task) {
        var result = restClient.get()
            .uri("/{id}", task.getAssignee())
            .retrieve()
            .toEntity(EmployeeDTO.class);

        var employeeDTO = result.getBody();

        if(result.getStatusCode().is2xxSuccessful()) {
            task.setAssignee(employeeDTO.id());
            taskRepository.save(task);

            var taskDetail = new TaskDetail();
            taskDetail.setEmployeeId(employeeDTO.id());
            taskDetail.setEmployeeFirstName(employeeDTO.firstName());
            taskDetail.setEmployeeLastName(employeeDTO.lastName());
            taskDetail.setTaskTitle(task.getTitle());
            taskDetail.setTaskDescription(task.getDescription());
            taskDetail.setTaskStatus(task.getStatus());
            taskDetail.setTaskPriority(task.getPriority());

            taskDetailService.saveTaskDetail(taskDetail);

            var taskNotificationDTO = new TaskNotificationDTO(task.getId(), employeeDTO.id(), task.getTitle(), task.getDescription());
            try {
                taskNotificationSender.sendToQueue(taskNotificationDTO);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Page<TaskDTO> getTasksPage(int pageSize, int pageNumber, String sortField, String sortDirection) {
        return null;
    }
}
