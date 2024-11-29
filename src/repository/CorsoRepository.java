package repository;
import config.DbConnection;
import model.Corso;
import model.Docente;
import java.sql.*;
import java.util.ArrayList;

public class CorsoRepository {

    //CREATE
    public void createCorso(Corso corso) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO CorsoTest VALUES('" + corso.getNomeCorso() + "','" + corso.getDataInizio()+ "','" + corso.getDurataCorso()+ "','" + corso.getIdDocente()+"')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    //READ
    public ArrayList<Corso> readCorso() {
        ArrayList<Corso> listaCorsi = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CorsoTest ORDER BY id asc");
            while (rs.next()) {
                Corso corso = new Corso();
                corso.setNomeCorso(rs.getString("NomeCorso"));
                corso.setDataInizio(rs.getString("dataCorso"));
                corso.setDurataCorso(rs.getString("durataCorso"));
                corso.setIdDocente(rs.getInt("idDocente"));
                corso.setIdCorso(rs.getInt("id"));
                listaCorsi.add(corso);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaCorsi;
    }

    //DELETE
    public void deleteCorso(Corso corso) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM CorsoTest WHERE id = '" + corso.getIdCorso() + "'");
            System.out.println("model.dao.Corso eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateCorso(Corso corso) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE CorsoTest SET " +
                    "nomeCorso='" + corso.getNomeCorso() + "', " +
                    "dataCorso='" + corso.getDataInizio() + "', " +
                    "durataCorso='" + corso.getDurataCorso() + "', " +
                    "idDocente=" + corso.getIdDocente() + " " +
                    "WHERE id=" + corso.getIdCorso());
            System.out.println("model.dao.Corso aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
