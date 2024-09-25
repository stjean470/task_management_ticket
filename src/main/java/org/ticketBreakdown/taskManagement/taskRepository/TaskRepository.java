package org.ticketBreakdown.taskManagement.taskRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketBreakdown.taskManagement.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
