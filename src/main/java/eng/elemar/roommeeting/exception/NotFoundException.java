package eng.elemar.roommeeting.exception;

import eng.elemar.roommeeting.utils.MessageUtils;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
    
}
