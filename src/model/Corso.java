package model;

import java.time.LocalDate;

public class Corso {
    private String nomeCorso;
    private String dataInizio;
    private String durataCorso;
    private int idDocente;
    private int idCorso;

    public void setNomeCorso(String nomeCorso)
    {
        this.nomeCorso = nomeCorso;
    }

    public String getNomeCorso ()
    {
        return nomeCorso;
    }

    public void setDataInizio (String dataInizio)
    {
        this.dataInizio = dataInizio;
    }

    public String getDataInizio()
    {
        return dataInizio;
    }

    public void setDurataCorso (String durataCorso)
    {
        this.durataCorso = durataCorso;
    }

    public String getDurataCorso ()
    {
        return durataCorso;
    }

    public void setIdDocente (int idDocente)
    {
        this.idDocente = idDocente;
    }

    public int getIdDocente ()
    {
        return idDocente;
    }

    public void getIdCorso (int id)
    {
        this.idCorso = idCorso;
    }

    public int setIdCorso ()
    {
        return idCorso;
    }
}