package service;
import model.Corso;
import repository.CorsoRepository;
import java.time.LocalDate;
import java.util.List;

public class CorsoService {
    CorsoRepository corsoRepository = new CorsoRepository();

    public void createCorso(String nomeCorso, String dataInizio, String durataCorso, int idDocente)
    {
        Corso corso = new Corso();
        corso.setNomeCorso(nomeCorso);
        corso.setDataInizio(dataInizio);
        corso.setDurataCorso (durataCorso);
        corso.setIdDocente(idDocente);
        corsoRepository.createCorso(corso);
    }
}
