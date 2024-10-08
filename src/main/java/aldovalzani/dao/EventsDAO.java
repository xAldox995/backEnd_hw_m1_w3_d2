package aldovalzani.dao;

import aldovalzani.eventclass.Evento;
import aldovalzani.expetions.EventDontFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventsDAO {
    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento newEvento) {
        EntityTransaction transiction = em.getTransaction();
        transiction.begin();
        em.persist(newEvento);
        transiction.commit();
        System.out.println("Evento " + newEvento.getTitolo() + " è stato inserito con successo");
    }

    public Evento getById(long id) {
        Evento found = em.find(Evento.class, id);
        if (found == null) {
            throw new EventDontFoundException(id);
        } else {
            return found;
        }
    }

    public void delEvento(long id) {
        Evento evFound = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(evFound);
        transaction.commit();
        System.out.println("L'evento con id " + id + " è stato eliminato");
    }
}
