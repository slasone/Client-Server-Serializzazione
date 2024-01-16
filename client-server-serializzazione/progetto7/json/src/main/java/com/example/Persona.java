package com.example;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }


    public Persona() {

    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }


    @Override
    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Eta: " + eta;
    }

}
