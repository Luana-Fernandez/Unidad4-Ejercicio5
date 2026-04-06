package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import java.util.List;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlanCreateDTO {
    
    @NotBlank
    @Size(min = 10, max = 200, message = "Debe tener entre 10 y 200 caracteres")
    private String objetivo;

    @NotNull
    @Min(value = 1) 
    @Max(value = 7)
    private Integer frecuenciaSemanal;

    @NotNull
    @DecimalMin(value = "30.0")
    @DecimalMax(value = "250.0")
    private Double pesoInicial;
    
    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "2.5")
    private Double altura;

    @NotNull(message = "La lista de ejercicios es obligatoria")
    @Size(min = 3, message = "tiene que haber al menos 3 ejercicios")
    private List<@NotBlank(message = "el ejercicio no puede estar vacio") String> ejercicios; //validacion a cada elemento de la lista
}
