package com.example.miniprojeto.controller;


import com.example.miniprojeto.model.Funcionario;
import com.example.miniprojeto.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){ this.service = service;}

    @GetMapping
    public List<Funcionario> listar(){// chamamos o listar que esta no service para o listar que tá no GetMapping, uma coisa chama a outra
        return service.listar();
    }

    @PostMapping
    public Funcionario criar(@RequestBody @Valid Funcionario funcionario){//o request vai transformar o objeto em JSON pra fazer a comunicação
        return service.inserir(funcionario);
    } //@Valid apenas procura a validação pra ver se os parâmetros estão válidos

    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario){ //Pegamos o ID antigo e o produto antigo
        funcionario.setId(id);//feito isso nós mudamos as informações que desejamos e setamos o id "novo" para sobreescrever os dados
        return service.inserir(funcionario);//Ai salvamos
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        service.remover(id);
    }

}
