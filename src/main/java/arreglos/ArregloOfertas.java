package arreglos;

import modelo.Oferta;

public class ArregloOfertas {
    private Oferta[] datos;
    private int indice;

    public ArregloOfertas() {
        datos = new Oferta[100];
        indice = 0;
    }

    public boolean agregar(Oferta oferta) {
        if (indice < datos.length) {
            datos[indice] = oferta;
            indice++;
            return true;
        }
        return false;
    }

    public Oferta buscar(String puesto) {
        for (int i = 0; i < indice; i++) {
            if (datos[i].getPuesto().equalsIgnoreCase(puesto)) {
                return datos[i];
            }
        }
        return null;
    }

    public void listar() {
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ". " + datos[i].getPuesto()
                    + " | Area: " + datos[i].getArea());
        }
    }

    public Oferta[] getDatos() {
        return datos;
    }

    public int getIndice() {
        return indice;
    }
}