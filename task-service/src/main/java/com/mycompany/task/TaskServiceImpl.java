package com.mycompany.task;

import com.mycompany.employee.EmployeeDTO;
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

    public TaskServiceImpl(TaskRepository taskRepository, TaskDTOMapper taskDTOMapper, RestClient restClient,
                           TaskDetailService taskDetailService
    ) {
        this.taskRepository = taskRepository;
        this.taskDTOMapper = taskDTOMapper;
        this.restClient = restClient;
        this.taskDetailService = taskDetailService;
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

        var employeeDto = result.getBody();

        if(result.getStatusCode().is2xxSuccessful()) {
            task.setAssignee(employeeDto.id());
            taskRepository.save(task);

            var taskDetail = new TaskDetail();
            taskDetail.setEmployeeId(employeeDto.id());
            taskDetail.setEmployeeFirstName(employeeDto.firstName());
            taskDetail.setEmployeeLastName(employeeDto.lastName());
            taskDetail.setTaskTitle(task.getTitle());
            taskDetail.setTaskDescription(task.getDescription());
            taskDetail.setTaskStatus(task.getStatus());
            taskDetail.setTaskPriority(task.getPriority());

            taskDetailService.saveTaskDetail(taskDetail);
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
