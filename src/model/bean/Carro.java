/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Rafael
 */
public class Carro {
    
    private int id;
    private String modelo;
    private int ano;
    private String reservado;
    private int locadoraID;
    private int pessoaID;
    private int seguroID;
    private String locadoraNome;
    private String pessoaNome;

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    
    
    public String getLocadoraNome() {
        return locadoraNome;
    }

    public void setLocadoraNome(String locadoraNome) {
        this.locadoraNome = locadoraNome;
    }

    
    
    public int getSeguroID() {
        return seguroID;
    }

    public void setSeguroID(int seguroID) {
        this.seguroID = seguroID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getReservado() {
        return reservado;
    }

    public void setReservado(String reservado) {
        this.reservado = reservado;
    }

    public int getLocadoraID() {
        return locadoraID;
    }

    public void setLocadoraID(int locadoraID) {
        this.locadoraID = locadoraID;
    }

    public int getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(int pessoaID) {
        this.pessoaID = pessoaID;
    }
    
}
