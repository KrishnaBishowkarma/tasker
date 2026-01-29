package np.com.krishnabk.tasker.mappers;

import np.com.krishnabk.tasker.domain.dto.TaskDto;
import np.com.krishnabk.tasker.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
