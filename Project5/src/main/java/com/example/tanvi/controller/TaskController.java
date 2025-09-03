package com.example.tanvi.controller;

import com.example.tanvi.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> taskList = new ArrayList<>();
    private int currentId = 1;

    //viewing tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskList;
    }

    //adding a task
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setId(currentId++);
        taskList.add(task);
        return task;
    }

    //updating a task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        Optional<Task> taskOptional = taskList.stream()
                                              .filter(t -> t.getId() == id)
                                              .findFirst();
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return task;
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    //deleting a task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        boolean removed = taskList.removeIf(task -> task.getId() == id);
        if (removed) {
            return "Task with ID " + id + " deleted.";
        } else {
            return "Task with ID " + id + " not found.";
        }
    }
}
