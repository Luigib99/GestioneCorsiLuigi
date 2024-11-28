package service;
import model.Discente;
import repository.DiscenteRepository;
import java.util.List;

public class DiscenteService {
    DiscenteRepository discenteRepository = new DiscenteRepository();

    public void create(String nome, String cognome, String matricola, String dataNascita) {
        Discente discente = new Discente();
        discente.setCognome(cognome);
        discente.setNome(nome);
        discente.setMatricola(matricola);
        discente.setDataNascita(dataNascita);
        discenteRepository.createDiscente(discente);
    }


    public List<Discente>  readDiscente(){
        return discenteRepository.readDiscente();
    }


    public void delete(int id) {
        Discente discente = new Discente();
        discente.setid(id);
        discenteRepository.deleteDiscente(discente);
    }

    public void update(int id, String nome, String cognome, String matricola, String dataNascita) {
        Discente discente = new Discente();
        discente.setNome(nome);
        discente.setCognome(cognome);
        discente.setMatricola(matricola);
        discente.setDataNascita(dataNascita);
        discente.setid(id);
        discenteRepository.updateDiscente(discente);
    }


}
