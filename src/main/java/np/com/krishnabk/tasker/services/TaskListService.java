package np.com.krishnabk.tasker.services;

import np.com.krishnabk.tasker.domain.entities.Task;
import np.com.krishnabk.tasker.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
