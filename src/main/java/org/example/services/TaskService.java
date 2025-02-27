package org.example.services;

import org.example.models.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * Služba na správu úloh.
 * Umožňuje pridávať úlohy a získať zoznam všetkých úloh.
 */
public class TaskService {

    /** Zoznam všetkých úloh. */
    private List<Task> tasks = new ArrayList<>();

    /**
     * Získa zoznam všetkých úloh.
     *
     * @return zoznam úloh
     */
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Pridá novú úlohu do zoznamu.
     *
     * @param task úloha, ktorá sa má pridať
     */
    public void addTask(Task task) {
        tasks.add(task);
    }
}
