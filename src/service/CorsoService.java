package service;
import model.Corso;
import model.Discente;
import model.Docente;
import repository.CorsoRepository;
import java.util.List;

public class CorsoService {
    CorsoRepository corsoRepository = new CorsoRepository();

    public void createCorso(String nomeCorso, String dataInizio, String durataCorso, int idDocente, Docente docente)
    {
        Corso corso = new Corso();
        corso.setNomeCorso(nomeCorso);
        corso.setDataInizio(dataInizio);
        corso.setDurataCorso (durataCorso);
        corso.setIdDocente(idDocente);
        corso.setDocente(docente);
        corsoRepository.createCorso(corso);
    }

    public List<Corso>  readCorso(){
        return corsoRepository.readCorso();
    }

    public void deleteCorso(int id) {
        Corso corso = new Corso();
        corso.setIdCorso(id);
        corsoRepository.deleteCorso(corso);
    }

    public void updateCorso(int idCorso, String nomeCorso, String dataInizio, String durataCorso, int idDocente) {
        Corso corso = new Corso();
        corso.setNomeCorso(nomeCorso);
        corso.setDataInizio(dataInizio);
        corso.setDurataCorso(durataCorso);
        corso.setIdDocente(idDocente);
        corso.setIdCorso(idCorso);
        corsoRepository.updateCorso(corso);
    }
}
