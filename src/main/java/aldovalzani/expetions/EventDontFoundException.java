package aldovalzani.expetions;

public class EventDontFoundException extends RuntimeException {
    public EventDontFoundException(long id) {
        super("L'evento con id " + id + " non è stato trovato");
    }
}
