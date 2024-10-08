package aldovalzani.eventclass;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome_evento", nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numero_max_partecipanti")
    private int numeroMassimoParticipanti;

    public Evento() {
    }

    public Evento(LocalDate dataEvento, String titolo, TipoEvento tipoEvento, int numeroMassimoParticipanti, String descrizione) {
        this.dataEvento = dataEvento;
        this.titolo = titolo;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoParticipanti = numeroMassimoParticipanti;
        this.descrizione = descrizione;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public long getId() {
        return id;
    }

    public int getNumeroMassimoParticipanti() {
        return numeroMassimoParticipanti;
    }

    public void setNumeroMassimoParticipanti(int numeroMassimoParticipanti) {
        this.numeroMassimoParticipanti = numeroMassimoParticipanti;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Evento {id= " + id +
                ", nome_evento= " + titolo + ", descrizione= " + descrizione +
                ", tipo_evento= " + tipoEvento + ", max_num_partecipanti= " + numeroMassimoParticipanti + '}';
    }
}
