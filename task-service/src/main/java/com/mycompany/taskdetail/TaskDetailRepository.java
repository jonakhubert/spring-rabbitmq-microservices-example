package com.mycompany.taskdetail;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDetailRepository extends ElasticsearchRepository<TaskDetail, String> {
    List<TaskDetail> findByTaskDescriptionContains(String taskDescription);
}
