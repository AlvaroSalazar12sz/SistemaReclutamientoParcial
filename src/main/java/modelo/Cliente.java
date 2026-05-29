package modelo;

public class Cliente {
    private String ruc;
    private String razonSocial;
    private String email;
    private String contacto;
    private String telefono;
    private String clave;

    private Rubro rubro;
    private Oferta[] ofertas;
    private int cantidadOfertas;

    public Cliente() {
        ofertas = new Oferta[20];
        cantidadOfertas = 0;
    }

    public Cliente(String ruc, String razonSocial, String email, String contacto, String telefono, String clave, Rubro rubro) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.email = email;
        this.contacto = contacto;
        this.telefono = telefono;
        this.clave = clave;
        this.rubro = rubro;
        ofertas = new Oferta[20];
        cantidadOfertas = 0;
    }

    public boolean agregarOferta(Oferta oferta) {
        if (cantidadOfertas < ofertas.length) {
            ofertas[cantidadOfertas] = oferta;
            cantidadOfertas++;
            return true;
        }
        return false;
    }

    public boolean eliminarOferta(Oferta oferta) {
        for (int i = 0; i < cantidadOfertas; i++) {
            if (ofertas[i] == oferta) {
                ofertas[i] = null;
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        return ofertas;
    }

    public int getCantidadOfertas() {
        return cantidadOfertas;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
}