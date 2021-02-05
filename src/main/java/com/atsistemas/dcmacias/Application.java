package com.atsistemas.dcmacias;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Prueba Tecnica Bnext",
                version = "1.0",
                description = "API Transaccional",
                contact = @Contact(email = "dcmacias@atsistemas.com", name = "Dionisio Carlos Macias")))
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
