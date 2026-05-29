package vista;

import java.util.Scanner;

public class VistaSistema {

    private Scanner teclado;

    public VistaSistema() {
        teclado = new Scanner(System.in);
    }

    public int menuPrincipal() {
        System.out.println("\n===== SISTEMA DE RECLUTAMIENTO TI =====");
        System.out.println("1. Registrar rubro");
        System.out.println("2. Registrar cliente empresa");
        System.out.println("3. Registrar postulante");
        System.out.println("4. Registrar oferta");
        System.out.println("5. Agregar requisito a oferta");
        System.out.println("6. Listar rubros");
        System.out.println("7. Listar clientes");
        System.out.println("8. Listar postulantes");
        System.out.println("9. Listar ofertas");
        System.out.println("10. Postular a oferta");
        System.out.println("11. Anular postulacion");
        System.out.println("12. Listar ofertas activas");
        System.out.println("13. Listar postulaciones de postulante");
        System.out.println("0. Salir");
        System.out.print("Ingrese opcion: ");

        int opcion = leerEnteroSinMensaje();
        return opcion;
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return leerEnteroSinMensaje();
    }

    private int leerEnteroSinMensaje() {
        int numero = -1;
        try {
            numero = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un numero.");
        }
        return numero;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}