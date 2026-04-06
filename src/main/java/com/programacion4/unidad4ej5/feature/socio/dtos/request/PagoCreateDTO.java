package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import java.time.LocalDate;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PagoCreateDTO {
    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "1000.0", message = "El monto debe ser mayor a 1000")
    @Digits(integer = 10, fraction = 2, message = "Maximo 2 decimales") //hasta 10 numeros antes del punto
    private Double monto;

    @NotBlank @Pattern(regexp = "PAY-[A-Z0-9]{4}-[A-Z0-9]{4}", message = "El código debe tener formato PAY-XXXX-XXXX") // exactamente 4 caracteres pueden ser letras mayusculas o numeros
    private String codigoDeTransaccion;

    @NotNull @Future(message = "La fecha debe ser futura")
    private LocalDate fechaDeVencimiento;

    @NotNull(message = "El tipo de pago es obligatorio")
    @Pattern(regexp = "EFECTIVO|DEBITO|CREDITO|TRANSFERENCIA", message = "Tipo de pago invalido")
    private String tipoDePago;

}
