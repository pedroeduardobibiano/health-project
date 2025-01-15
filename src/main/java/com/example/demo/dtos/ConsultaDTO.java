package com.example.demo.dtos;

import com.example.demo.entities.Consulta;
import com.example.demo.entities.Medico;
import com.example.demo.entities.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsultaDTO {

    private Long id;


    private Instant dataConsulta;


    private Paciente paciente;


    private Medico medico;


    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.dataConsulta = consulta.getDataConsulta();
        this.paciente = consulta.getPaciente();
        this.medico = consulta.getMedico();
    }

}
