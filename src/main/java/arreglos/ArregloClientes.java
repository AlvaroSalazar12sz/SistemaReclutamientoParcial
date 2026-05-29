package arreglos;

import modelo.Cliente;

public class ArregloClientes {
    private Cliente[] datos;
    private int indice;

    public ArregloClientes() {
        datos = new Cliente[50];
        indice = 0;
    }

    public boolean agregar(Cliente cliente) {
        if (buscar(cliente.getRuc()) == null && indice < datos.length) {
            datos[indice] = cliente;
            indice++;
            return true;
        }
        return false;
    }

    public Cliente buscar(String ruc) {
        for (int i = 0; i < indice; i++) {
            if (datos[i].getRuc().equals(ruc)) {
                return datos[i];
            }
        }
        return null;
    }

    public void listar() {
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ". " + datos[i].getRazonSocial()
                    + " | RUC: " + datos[i].getRuc()
                    + " | Rubro: " + datos[i].getRubro().getNombre());
        }
    }

    public Cliente[] getDatos() {
        return datos;
    }

    public int getIndice() {
        return indice;
    }
}