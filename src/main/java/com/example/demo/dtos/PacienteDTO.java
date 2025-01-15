package com.example.demo.dtos;

import com.example.demo.entities.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    private Long id;

    @Size(min = 3, max = 60, message = "Nome invalido (maximo 60 caracteres, min 3)")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Pattern(regexp = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)", message = "Cpf Invalido")
    @NotBlank(message = "Campo requerido")
    private String cpf;

    private Date dataNascimento;
    private String rg;

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.name = paciente.getName();
        this.cpf = paciente.getCpf();
        this.dataNascimento = paciente.getDataNascimento();
        this.rg = paciente.getRg();
    }

}
