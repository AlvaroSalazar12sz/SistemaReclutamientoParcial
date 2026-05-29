package modelo;

import java.util.Date;

public class Postulacion {
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;

    private Oferta oferta;

    public Postulacion(){
    }

    public Postulacion(Date fecha, boolean anulado, Oferta oferta){
        this.fecha = fecha;
        this.anulado = anulado;
        this.oferta = oferta;
    }

    public boolean anular(){
        anulado = true;
        fechaAnulacion = new Date();
        return true;
    }

    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public boolean isAnulado(){
        return anulado;
    }

    public void setAnulado(boolean anulado){
        this.anulado =anulado;
    }

    public Date getFechaAnulacion(){
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion){
        this.fechaAnulacion = fechaAnulacion;
    }

    public Oferta getOferta(){
        return oferta;
    }

    public void setOferta(Oferta oferta){
        this.oferta = oferta;
    }
}