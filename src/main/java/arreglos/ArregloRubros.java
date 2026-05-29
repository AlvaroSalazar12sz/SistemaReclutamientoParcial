package arreglos;

import modelo.Rubro;

public class ArregloRubros {
    private Rubro[] datos;
    private int indice;

    public ArregloRubros() {
        datos = new Rubro[50];
        indice = 0;
    }

    public boolean agregar(Rubro rubro) {
        if (indice < datos.length) {
            datos[indice] = rubro;
            indice++;
            return true;
        }
        return false;
    }

    public Rubro buscar(String nombre) {
        for (int i = 0; i < indice; i++) {
            if (datos[i].getNombre().equalsIgnoreCase(nombre)) {
                return datos[i];
            }
        }
        return null;
    }

    public void listar() {
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ". " + datos[i].getNombre());
        }
    }

    public Rubro[] getDatos() {
        return datos;
    }

    public int getIndice() {
        return indice;
    }
}