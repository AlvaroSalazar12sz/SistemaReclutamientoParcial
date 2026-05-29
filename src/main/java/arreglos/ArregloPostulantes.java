package arreglos;

import modelo.Postulante;

public class ArregloPostulantes {
    private Postulante[] datos;
    private int indice;

    public ArregloPostulantes() {
        datos = new Postulante[100];
        indice = 0;
    }

    public boolean agregar(Postulante postulante) {
        if (buscar(postulante.getEmail()) == null && indice < datos.length) {
            datos[indice] = postulante;
            indice++;
            return true;
        }
        return false;
    }

    public Postulante buscar(String email) {
        for (int i = 0; i < indice; i++) {
            if (datos[i].getEmail().equalsIgnoreCase(email)) {
                return datos[i];
            }
        }
        return null;
    }

    public void listar() {
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ". " + datos[i].getNombres()
                    + " " + datos[i].getApellidos()
                    + " | Email: " + datos[i].getEmail());
        }
    }

    public Postulante[] getDatos() {
        return datos;
    }

    public int getIndice() {
        return indice;
    }
}