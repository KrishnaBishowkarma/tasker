package np.com.krishnabk.tasker.controllers;

import np.com.krishnabk.tasker.domain.dto.TaskDto;
import np.com.krishnabk.tasker.domain.entities.Task;
import np.com.krishnabk.tasker.mappers.TaskMapper;
import np.com.krishnabk.tasker.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/task-lists/{task_list_id}/tasks")
public class TasksController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TasksController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id")UUID taskListId){
        return taskService.listTasks(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskDto createTask(
            @PathVariable("task_list_id")UUID taskListId,
            @RequestBody TaskDto taskDto){
        Task createdTask = taskService.createTask(
                taskListId,
                taskMapper.fromDto(taskDto)
        );

        return taskMapper.toDto(createdTask);
    }
}
