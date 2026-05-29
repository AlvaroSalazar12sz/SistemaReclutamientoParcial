package modelo;

import java.util.Date;

public class Oferta {
    private String puesto;
    private String descripcion;
    private String area;
    private Date fechaInicio;
    private Date fechaTermino;

    private Requisito[] requisitos;
    private int cantidadRequisitos;

    public Oferta() {
        requisitos = new Requisito[20];
        cantidadRequisitos = 0;
    }

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        requisitos = new Requisito[20];
        cantidadRequisitos = 0;
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        if (cantidadRequisitos < requisitos.length) {
            requisitos[cantidadRequisitos] = new Requisito(orden, descripcion, true);
            cantidadRequisitos++;
            return true;
        }
        return false;
    }

    public boolean eliminarRequisito(int orden) {
        for (int i = 0; i < cantidadRequisitos; i++) {
            if (requisitos[i].getOrden() == orden) {
                requisitos[i].deshabilitar();
                return true;
            }
        }
        return false;
    }

    public boolean estaActiva() {
        Date hoy = new Date();

        if (fechaInicio == null || fechaTermino == null) {
            return false;
        }

        return !hoy.before(fechaInicio) && !hoy.after(fechaTermino);
    }

    public Requisito[] getRequisitos() {
        return requisitos;
    }

    public int getCantidadRequisitos() {
        return cantidadRequisitos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
}