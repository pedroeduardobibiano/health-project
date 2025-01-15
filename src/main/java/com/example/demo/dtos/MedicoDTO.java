package com.example.demo.dtos;

import com.example.demo.entities.Medico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Size(min = 3, max = 60, message = "Nome invalido (maximo 60 caracteres, min 3)")
    @NotBlank(message = "Campo requerido")
    private String name;

    @NotBlank(message = "Campo requerido")
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
