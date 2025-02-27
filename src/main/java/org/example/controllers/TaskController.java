package org.example.controllers;

import org.example.models.Task;
import org.example.services.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * RestController pre správu úloh (Tasks).
 * Poskytuje endpointy na získanie a pridanie úloh.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService = new TaskService();

    /**
     * Získa zoznam všetkých úloh.
     *
     * @return Zoznam úloh.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Pridá novú úlohu do systému.
     *
     * @param task Úloha na pridanie.
     */
    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

}
