package eng.elemar.roommeeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eng.elemar.roommeeting.model.RoomMeeting;

public interface RoomMeetingRepository extends JpaRepository<RoomMeeting, Integer>{
    
}
