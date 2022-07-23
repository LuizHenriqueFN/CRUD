package com.crud.luiz.model;

public class Dados {
    
    public Dados(int id, String Nome, String Apelido, String Time, String CPF, String Hobbie, String Cidade, int Quantidade, String Estado){
        //Pessoa:
        this.id = id;
        this.Nome = Nome;
        this.Apelido = Apelido;
        this.Time = Time;
        this.CPF = CPF;
        this.Hobbie = Hobbie;
        //Cidade:
        this.Cidade = Cidade;
        this.Quantidade = Quantidade;
        this.Estado = Estado;
    }

    public Dados(){}

    //Pessoa:
    private int id;
    private String Nome;
    private String Apelido;
    private String Time;
    private String CPF;
    private String Hobbie;
    //Cidade:
    private String Cidade;
    private int Quantidade;
    private String Estado;

            //Pessoa:
    //ID:
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    //Nome:
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getNome() {
        return Nome;
    }
    //Apelido:
    public void setApelido(String apelido) {
        Apelido = apelido;
    }
    public String getApelido() {
        return Apelido;
    }
    //Time:
    public void setTime(String time) {
        Time = time;
    }
    public String getTime() {
        return Time;
    }
    //CPF:
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getCPF() {
        return CPF;
    }
    //Hobbie:
    public void setHobbie(String hobbie) {
        Hobbie = hobbie;
    }
    public String getHobbie() {
        return Hobbie;
    }
    
            //Cidade:
    //Nome da Cidade:
    public void setCidade(String cidade) {
        Cidade = cidade;
    }
    public String getCidade() {
        return Cidade;
    }
    //Quantidade de habitantes:
    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }
    public int getQuantidade() {
        return Quantidade;
    }
    //Estado:
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getEstado() {
        return Estado;
    }

}
