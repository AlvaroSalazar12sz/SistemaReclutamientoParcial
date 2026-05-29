package modelo;

import java.util.Date;

public class Postulacion {
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;
    private String rutaCV;

    private Oferta oferta;

    public Postulacion() {
    }

    public Postulacion(Date fecha, boolean anulado, Oferta oferta, String rutaCV) {
        this.fecha = fecha;
        this.anulado = anulado;
        this.oferta = oferta;
        this.rutaCV = rutaCV;
    }

    public boolean anular() {
        if (!anulado) {
            anulado = true;
            fechaAnulacion = new Date();
            return true;
        }
        return false;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public String getRutaCV() {
        return rutaCV;
    }

    public void setRutaCV(String rutaCV) {
        this.rutaCV = rutaCV;
    }
}