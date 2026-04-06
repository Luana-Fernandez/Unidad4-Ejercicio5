package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class SocioCreateDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @Email @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener 8 digitos") // d es la cant de digitos minimos y maximos
    private String dni;

    @NotNull @Past(message = "La fecha debe ser pasada y mayor a 18 años")
    private LocalDate fechaNacimiento;

    @NotBlank
    @Pattern(regexp = "\\+\\d{10,15}", message = "El teléfono debe tener entre 10 y 15 dígitos y comenzar con +")
    private String telefono;

    @AssertTrue(message = "Debe ser mayor de 18 años") //funciona como validacion personalizada
    public boolean isMayorDeEdad() {
        if (fechaNacimiento == null) return false;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }
}
