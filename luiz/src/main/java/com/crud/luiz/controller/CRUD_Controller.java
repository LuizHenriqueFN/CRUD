package com.crud.luiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.luiz.model.Dados;


@Controller
public class CRUD_Controller {

    List<Dados> Banco_de_Dados = new ArrayList<>();

    @GetMapping("/Index")
    public ModelAndView Pag_Inicial(){
        ModelAndView MV = new ModelAndView("index");
        MV.addObject("Pessoa", new Dados());
        return MV;
    }

    @PostMapping("/Index")
    public String Cadastra(Dados pessoa){
        if(pessoa.getId() != 0){
            Dados Nova_Pessoa = Banco_de_Dados.stream().filter(P_Editando -> pessoa.getId() == P_Editando.getId()).findFirst().get();
            
            Banco_de_Dados.set(Banco_de_Dados.indexOf(Nova_Pessoa), pessoa);   
        }else{
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
        }        
        return "redirect:/Tabela"; //Nome HTML
    }

    @GetMapping("/Tabela")
    public ModelAndView Tabela(){
        ModelAndView MV = new ModelAndView("Tabela");
        MV.addObject("Banco_De_Dados", Banco_de_Dados);
        return MV;
    }

    @GetMapping("/Editar/{id}")
    public ModelAndView Editar(@PathVariable("id") int id){
        ModelAndView MV = new ModelAndView("index");

        Dados Pessoa = Banco_de_Dados.stream()
                                     .filter(Dados -> id == Dados.getId())
                                     .findFirst()
                                     .get();
        MV.addObject("Pessoa", Pessoa);
        return MV;
    }

    @GetMapping("/Remover/{id}")
    public String Remover(@PathVariable("id") int id){
        Dados Pessoa = Banco_de_Dados.stream()
                                     .filter(Dados -> id == Dados.getId())
                                     .findFirst()
                                     .get();
        Banco_de_Dados.remove(Pessoa);
        
        return "redirect:/Tabela";
    }
}   


