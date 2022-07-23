package com.crud.luiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.luiz.model.Dados;


@Controller
public class CRUD_Controller {

    List<Dados> Banco_de_Dados = new ArrayList<>();

    @GetMapping("/Index")
    public String Pag_Inicial(){
        return "index"; //Nome HTML
    }

    @PostMapping("/Index")
    public String Cadastra(Dados pessoa){
        int id = Banco_de_Dados.size() + 1;
        
        Banco_de_Dados.add(new Dados(
            id,
            pessoa.getNome(),
            pessoa.getApelido(),
            pessoa.getTime(),
            pessoa.getCPF(),
            pessoa.getHobbie(),
            pessoa.getCidade(),
            pessoa.getQuantidade(),
            pessoa.getEstado()
        ));
        return "redirect:/Tabela"; //Nome HTML
    }

    @GetMapping("/Tabela")
    public String Tabela(){
        return "Tabela";
    }
}   


