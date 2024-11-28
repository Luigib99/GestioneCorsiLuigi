package model;

public class Discente {
    private String nome;
    private String cognome;
    private String matricola;
    private String dataNascita;
    private int id;

    //NOME

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    //COGNOME

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {return cognome;}

    //MATRICOLA

    public void setMatricola (String matricola) {this.matricola = matricola;}

    public String getMatricola() {return matricola;}

    //ID
    public void setid(int id) {this.id = id;}

    public int getid() {
        return id;
    }

    //DATA NASCITA

    public void setDataNascita(String dataNascita) {this.dataNascita = dataNascita;}

    public String getDataNascita() {return dataNascita;}

}
