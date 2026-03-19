package com.example.miniprojeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio!")
    private String nome;

    @Column(unique = true)
    @Email(message = "O email não é válido!")
    private String email;

    @NotBlank(message = "O cargo não pode ser vazio!")
    private String cargo;

    @NotNull(message = "O salário não pode ser >0/Vazio!")
    @Positive(message = "O valor tem que ser positivo/maior que zero!")
    private Double salario;


}
