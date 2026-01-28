package np.com.krishnabk.tasker.domain.dto;

import np.com.krishnabk.tasker.domain.entities.TaskPriority;
import np.com.krishnabk.tasker.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
