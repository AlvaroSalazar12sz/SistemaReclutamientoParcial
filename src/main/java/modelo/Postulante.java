package modelo;

import java.util.Date;

public class Postulante {
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;

    private GradoEstudio gradoEstudio;
    private Postulacion[] postulaciones;
    private int cantidadPostulaciones;

    public Postulante() {
        postulaciones = new Postulacion[50];
        cantidadPostulaciones = 0;
    }

    public Postulante(String email, String nombres, String apellidos, String direccion, Date nacimiento, String clave) {
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.clave = clave;
        postulaciones = new Postulacion[50];
        cantidadPostulaciones = 0;
    }

    public boolean asignarGradoEstudio(GradoEstudio gradoEstudio) {
        this.gradoEstudio = gradoEstudio;
        return true;
    }

    public boolean postular(Oferta oferta) {
        if (cantidadPostulaciones < postulaciones.length) {
            postulaciones[cantidadPostulaciones] = new Postulacion(new Date(), false, oferta);
            cantidadPostulaciones++;
            return true;
        }
        return false;
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        if (postulacion != null) {
            return postulacion.anular();
        }
        return false;
    }

    public Postulacion[] getPostulaciones() {
        return postulaciones;
    }

    public String getEmail() {
        return email;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public GradoEstudio getGradoEstudio() {
        return gradoEstudio;
    }

    public int getCantidadPostulaciones() {
        return cantidadPostulaciones;
    }
}