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
public class PacienteDTO {

    private String name;
    private String cpf;
    private Date dataNascimento;
    private String rg;

    public PacienteDTO(Paciente paciente) {
        this.name = paciente.getName();
        this.cpf = paciente.getCpf();
        this.dataNascimento = paciente.getDataNascimento();
        this.rg = paciente.getRg();
    }

}
