package com.example.miniprojeto.repository;

import com.example.miniprojeto.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findBySalarioGreaterThan(Double salario);

}
