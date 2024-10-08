package aldovalzani;

import aldovalzani.dao.EventsDAO;
import aldovalzani.eventclass.Evento;
import aldovalzani.expetions.EventDontFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
//        Evento ev1 = new Evento(LocalDate.of(2027, 8, 10),
//                "Matrimonio", TipoEvento.PRIVATO, 100, "Buona fortuna");

        EntityManager em = emf.createEntityManager();
        EventsDAO myDaos = new EventsDAO(em);

//        myDaos.save(ev1);

        try {
            Evento evFound = myDaos.getById(2);
            System.out.println(evFound);
        } catch (EventDontFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
