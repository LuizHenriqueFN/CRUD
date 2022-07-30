package com.crud.luiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.luiz.model.Dados;
import com.crud.luiz.repository.Banco_De_Dados;
import com.crud.luiz.repository.CPF;

@Controller
public class CRUD_Controller {

    @Autowired
    private Banco_De_Dados Funcao;

    @GetMapping("/Index")
    public ModelAndView Pag_Inicial(){
        ModelAndView MV = new ModelAndView("index");
        MV.addObject("Pessoa", new Dados());
        return MV;
    }

    @PostMapping("/Index")
    public String Cadastrar(Dados pessoa){
            String CPF_Atual = (pessoa.getCPF());
            CPF_Atual = CPF_Atual.replace(".","");
            CPF_Atual = CPF_Atual.replace("-","");

            if(CPF_Atual.length() != 11){
                return "redirect:/Pagina_Erro";
            }

            CPF cpf = new CPF(CPF_Atual);
            if(cpf.Valido()){
                int id = pessoa.getId();

                Dados NovaPessoa = new Dados(
                    id,
                    pessoa.getNome(),
                    pessoa.getApelido(),
                    pessoa.getTime(),
                    pessoa.getCPF(),
                    pessoa.getHobbie(),
                    pessoa.getCidade(),
                    pessoa.getQuantidade(),
                    pessoa.getEstado()
                );
                Funcao.save(NovaPessoa);
            }else{
                return "redirect:/Pagina_Erro";
            }
        return "redirect:/Tabela"; //Nome HTML
    }

    @GetMapping("/Tabela")
    public ModelAndView Tabela(){
        ModelAndView MV = new ModelAndView("Tabela");
        MV.addObject("Banco_De_Dados", Funcao.findAll());
        return MV;
    }

    @GetMapping("/Editar/{id}")
    public ModelAndView Editar(@PathVariable("id") int id){
        ModelAndView MV = new ModelAndView("index");

        MV.addObject("Pessoa", Funcao.findByid(id));
        return MV;
    }

    @GetMapping("/Remover/{id}")
    public String Remover(@PathVariable("id") int id){
        Funcao.delete(Funcao.findByid(id));
        
        return "redirect:/Tabela";
    }

    @GetMapping("/Pagina_Erro")
    public String AvisaERRO(){
        return "Pagina_Erro";
    }
    
}   


