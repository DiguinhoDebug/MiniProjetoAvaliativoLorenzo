package com.example.miniprojeto.service;

import com.example.miniprojeto.model.Funcionario;
import com.example.miniprojeto.repository.FuncionarioRepository;
import org.springframework.boot.data.metrics.DefaultRepositoryTagsProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {


    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario inserir(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public List<Funcionario> listar(){ return repository.findAll(); }

    public Funcionario buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public void remover(Long id){
        repository.deleteById(id);
    }

}
