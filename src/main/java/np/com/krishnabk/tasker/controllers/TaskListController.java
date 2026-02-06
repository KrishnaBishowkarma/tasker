package np.com.krishnabk.tasker.controllers;

import np.com.krishnabk.tasker.domain.dto.TaskListDto;
import np.com.krishnabk.tasker.domain.entities.TaskList;
import np.com.krishnabk.tasker.mappers.TaskListMapper;
import np.com.krishnabk.tasker.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskLists(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping("/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id")UUID taskListId){
        return taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }

    @PutMapping("/{task_list_id}")
    public TaskListDto updateTaskList(
            @PathVariable("task_list_id")UUID taskListId,
            @RequestBody TaskListDto taskListDto
    ) {
        TaskList updatedTaskList = taskListService.updateTaskList(
                taskListId,
                taskListMapper.fromDto(taskListDto)
        );

        return taskListMapper.toDto(updatedTaskList);
    }
}


