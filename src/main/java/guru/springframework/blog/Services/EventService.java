package guru.springframework.blog.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import guru.springframework.blog.dto.Event;
import guru.springframework.blog.util.EncodeUtil;

public class EventService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public void insertEvent(Event event) {
        // Log the raw event
        logger.info(event.getEventId());

        // TODO: Insert the event into the database
    }

    public void insertEventSanitized(Event event) {
        // Log the raw event
        logger.info(EncodeUtil.encodeForJava(event.getEventId()));

        // TODO: Insert the event into the database
    }
}

