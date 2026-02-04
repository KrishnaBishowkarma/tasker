package np.com.krishnabk.tasker.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
