package repository;
import config.DbConnection;
import model.Corso;
import java.sql.*;

public class CorsoRepository {

    public void createCorso(Corso corso) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO CorsoTest VALUES('" + corso.getNomeCorso() + "','"
                                                                 + corso.getDataInizio()+ "','"
                                                                  + corso.getDurataCorso()+ "','"
                                                                  + corso.getIdDocente()+ "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
