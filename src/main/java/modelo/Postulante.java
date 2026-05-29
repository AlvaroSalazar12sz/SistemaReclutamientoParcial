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

    public boolean postular(Oferta oferta, String rutaCV) {
        if (rutaCV == null || rutaCV.equals("")) {
            return false;
        }

        if (cantidadPostulaciones < postulaciones.length) {
            postulaciones[cantidadPostulaciones] = new Postulacion(new Date(), false, oferta, rutaCV);
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

    public int getCantidadPostulaciones() {
        return cantidadPostulaciones;
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

    public String getDireccion() {
        return direccion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public String getClave() {
        return clave;
    }

    public GradoEstudio getGradoEstudio() {
        return gradoEstudio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}