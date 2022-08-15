package com.example.diarioescolar.model;

import java.util.Date;
import java.util.List;

public class Aluno {
    private Integer id;
    private String nome;
    private String CPF;
    private String email;
    private Date dataNascimento;
    private String telefone;
    private List<String> areasInteresse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getAreasInteresse() {
        return areasInteresse;
    }

    public void setAreasInteresse(List<String> areasInteresse) {
        this.areasInteresse = areasInteresse;
    }
}
