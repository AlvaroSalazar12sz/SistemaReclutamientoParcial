package com.mycompany.sistemareclutamiento;

import modelo.Cliente;
import modelo.Rubro;

public class SistemaReclutamiento{

    public static void main(String[] args){

        Rubro rubro = new Rubro("Tecnologia", true);

        Cliente cliente = new Cliente(
                "20123456789",
                "Tech Solutions SAC",
                "contacto@tech.com",
                "Carlos Perez",
                "999888777",
                "123456",
                rubro
        );

        System.out.println("Sistema de Reclutamiento TI iniciado");
        System.out.println("Cliente registrado: " + cliente.getRazonSocial());
        System.out.println("Rubro: " + rubro.getNombre());
    }
}