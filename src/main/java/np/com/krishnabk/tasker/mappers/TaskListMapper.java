package np.com.krishnabk.tasker.mappers;

import np.com.krishnabk.tasker.domain.dto.TaskListDto;
import np.com.krishnabk.tasker.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);

}
