package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.*;

interface OnCreate {}
interface OnUpdate {}

public class SocioUpdateDTO {
    
    @Null(groups = OnCreate.class, message = "El id debe ser nulo al crear")
    @NotNull(groups = OnUpdate.class, message = "El id es obligatorio al actualizar")
    private Long id;
    
    @URL(message = "La url debe ser válida")
    private String urlFoto;

    @Size(min = 3, max = 15, message = "El alias debe tener entre 3 y 15 caracteres")
    @Pattern(regexp = "\\S+", message = "El alias no debe tener espacios")
    private String alias;
}
