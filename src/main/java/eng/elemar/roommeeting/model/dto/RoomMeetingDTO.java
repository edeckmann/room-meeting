package eng.elemar.roommeeting.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomMeetingDTO {
    private Integer id;
    private String name;
    private String date;
    private String startHour;
    private String endHour;
}
