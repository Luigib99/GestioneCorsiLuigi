package repository;
import config.DbConnection;
import model.Discente;
import java.sql.*;
import java.util.ArrayList;

public class DiscenteRepository {
    public void createDiscente(Discente discente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO DiscenteTest VALUES('" + discente.getNome() + "','" + discente.getCognome()+ "','" + discente.getDataNascita()+ "','" + discente.getMatricola() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Discente> readDiscente() {
        ArrayList<Discente> listaDiscenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DiscenteTest ORDER BY id asc");
            while (rs.next()) {
                Discente discente = new Discente();
                discente.setNome(rs.getString("nome"));
                discente.setCognome(rs.getString("cognome"));
                discente.setMatricola(rs.getString("matricola"));
                discente.setDataNascita(rs.getString("dataNascita"));
                discente.setid(rs.getInt("id"));
                listaDiscenti.add(discente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDiscenti;
    }

    public void deleteDiscente(Discente discente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM DocenteTest WHERE id = '" + discente.getid() + "'");
            System.out.println("model.dao.Discente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateDiscente(Discente discente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE DiscenteTest SET nome='" + discente.getNome() + "', " + "cognome='" + discente.getCognome()+ "', " + "matricola='" + discente.getMatricola () + "', " + "dataNascita='" + discente.getDataNascita () + "', " + "WHERE id =" + discente.getid());
            System.out.println("model.dao.Discente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
