package guru.springframework.blog.dto;

public class Event {
    private String eventId;

    public Event(String eventId) {
        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }
}