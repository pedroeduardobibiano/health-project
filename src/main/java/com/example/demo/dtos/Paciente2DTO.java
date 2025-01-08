package com.example.demo.dtos;

import com.example.demo.entities.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente2DTO {

    private Long id;
    private String name;
    private String cpf;

    public Paciente2DTO(Paciente paciente) {
        this.id = paciente.getId();
        this.name = paciente.getName();
        this.cpf = paciente.getCpf();
    }

}
