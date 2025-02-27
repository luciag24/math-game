package org.example.controllers;

import org.example.models.Task;
import org.example.services.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService = new TaskService();

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

}
