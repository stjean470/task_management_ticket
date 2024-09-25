package org.ticketBreakdown.taskManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.ticketBreakdown.taskManagement.model.Task;
import org.ticketBreakdown.taskManagement.taskRepository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Integer id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setStatus(updatedTask.getStatus());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
