package com.example.demo.dtos;

import com.example.demo.entities.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicoDTO {

    private Long id;

    private String name;

    private String crm;

    private String area;

    private Double avaliacao;

    public MedicoDTO(Medico medico) {
        this.id = medico.getId();
        this.name = medico.getName();
        this.crm = medico.getCrm();
        this.area = medico.getArea();
        this.avaliacao = medico.getAvaliacao();
    }

}
