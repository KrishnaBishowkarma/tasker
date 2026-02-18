package np.com.krishnabk.tasker.services;

import np.com.krishnabk.tasker.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task createTask(UUID taskListId, Task task);
}
