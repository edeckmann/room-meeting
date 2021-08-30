package eng.elemar.roommeeting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.roommeeting.exception.BusinessException;
import eng.elemar.roommeeting.exception.NotFoundException;
import eng.elemar.roommeeting.mapper.MapperUtil;
import eng.elemar.roommeeting.model.RoomMeeting;
import eng.elemar.roommeeting.model.dto.RoomMeetingDTO;
import eng.elemar.roommeeting.repository.RoomMeetingRepository;
import eng.elemar.roommeeting.utils.MessageUtils;

@Service
public class RoomMeetingService {
    @Autowired
    private RoomMeetingRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public RoomMeetingDTO save(RoomMeetingDTO dto) {
        RoomMeeting room = mapper.mapTo(dto, RoomMeeting.class);
        repository.save(room);
        return mapper.mapTo(room, RoomMeetingDTO.class);
    }

    @Transactional
    public RoomMeetingDTO update(RoomMeetingDTO dto) {
        Optional<RoomMeeting> roomExists = repository.findById(dto.getId());
        if (!roomExists.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        RoomMeeting room = mapper.mapTo(dto, RoomMeeting.class);
        repository.save(room);
        return mapper.mapTo(room, RoomMeetingDTO.class);
    }

    @Transactional
    public RoomMeetingDTO delete(Integer id) {
        RoomMeetingDTO room = this.findById(id);
        repository.deleteById(room.getId());
        return room;
    }

    @Transactional(readOnly = true)
    public List<RoomMeetingDTO> findAll() {
        List<RoomMeeting> list = repository.findAll();
        return mapper.mapList(list, RoomMeetingDTO.class);
    }

    @Transactional(readOnly = true)
    public RoomMeetingDTO findById(Integer id) {
        RoomMeeting room = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(room, RoomMeetingDTO.class);
    }
}
