package controlador;

import arreglos.ArregloClientes;
import arreglos.ArregloOfertas;
import arreglos.ArregloPostulantes;
import arreglos.ArregloRubros;
import java.util.Date;
import modelo.Cliente;
import modelo.GradoEstudio;
import modelo.Oferta;
import modelo.Postulacion;
import modelo.Postulante;
import modelo.Rubro;
import vista.VistaSistema;

public class ControladorSistema {

    private VistaSistema vista;

    private ArregloRubros arregloRubros;
    private ArregloClientes arregloClientes;
    private ArregloPostulantes arregloPostulantes;
    private ArregloOfertas arregloOfertas;

    public ControladorSistema() {
        vista = new VistaSistema();

        arregloRubros = new ArregloRubros();
        arregloClientes = new ArregloClientes();
        arregloPostulantes = new ArregloPostulantes();
        arregloOfertas = new ArregloOfertas();
    }

    private String generarClave(String prefijo) {
        int numero = (int) (Math.random() * 9000) + 1000;
        return prefijo + numero;
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = vista.menuPrincipal();

            switch (opcion) {
                case 1:
                    registrarRubro();
                    break;

                case 2:
                    registrarCliente();
                    break;

                case 3:
                    registrarPostulante();
                    break;

                case 4:
                    registrarOferta();
                    break;

                case 5:
                    agregarRequisitoOferta();
                    break;

                case 6:
                    listarRubros();
                    break;

                case 7:
                    listarClientes();
                    break;

                case 8:
                    listarPostulantes();
                    break;

                case 9:
                    listarOfertas();
                    break;

                case 10:
                    postularAOferta();
                    break;

                case 11:
                    anularPostulacion();
                    break;

                case 12:
                    listarOfertasActivas();
                    break;

                case 13:
                    listarPostulacionesPostulante();
                    break;

                case 0:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("Opcion incorrecta.");
                    break;
            }

        } while (opcion != 0);
    }

    public void registrarRubro() {
        String nombre = vista.leerTexto("Ingrese nombre del rubro: ");

        Rubro rubroExistente = arregloRubros.buscar(nombre);

        if (rubroExistente != null) {
            vista.mostrarMensaje("El rubro ya existe.");
            return;
        }

        Rubro rubro = new Rubro(nombre, true);
        arregloRubros.agregar(rubro);

        vista.mostrarMensaje("Rubro registrado correctamente.");
    }

    public void registrarCliente() {
        String ruc = vista.leerTexto("Ingrese RUC: ");

        Cliente clienteExistente = arregloClientes.buscar(ruc);

        if (clienteExistente != null) {
            vista.mostrarMensaje("Ya existe un cliente con ese RUC.");
            return;
        }

        String razonSocial = vista.leerTexto("Ingrese razon social: ");
        String email = vista.leerTexto("Ingrese correo institucional: ");
        String contacto = vista.leerTexto("Ingrese persona de contacto: ");
        String telefono = vista.leerTexto("Ingrese telefono: ");
        String clave = generarClave("EMP");

        String nombreRubro = vista.leerTexto("Ingrese rubro de la empresa: ");
        Rubro rubro = arregloRubros.buscar(nombreRubro);

        if (rubro == null) {
            vista.mostrarMensaje("El rubro no existe. Primero debe registrar el rubro.");
            return;
        }

        Cliente cliente = new Cliente(
                ruc,
                razonSocial,
                email,
                contacto,
                telefono,
                clave,
                rubro
        );

        arregloClientes.agregar(cliente);

        vista.mostrarMensaje("Cliente registrado correctamente.");
        vista.mostrarMensaje("Clave generada y enviada al correo: " + clave);
    }

    public void registrarPostulante() {
        String email = vista.leerTexto("Ingrese email del postulante: ");

        Postulante postulanteExistente = arregloPostulantes.buscar(email);

        if (postulanteExistente != null) {
            vista.mostrarMensaje("El postulante ya esta registrado.");
            return;
        }

        String nombres = vista.leerTexto("Ingrese nombres: ");
        String apellidos = vista.leerTexto("Ingrese apellidos: ");
        String direccion = vista.leerTexto("Ingrese direccion completa: ");
        String clave = generarClave("POS");

        String gradoDescripcion = vista.leerTexto("Ingrese grado de estudios: ");
        GradoEstudio grado = new GradoEstudio(gradoDescripcion);

        Postulante postulante = new Postulante(
                email,
                nombres,
                apellidos,
                direccion,
                new Date(),
                clave
        );

        postulante.asignarGradoEstudio(grado);
        arregloPostulantes.agregar(postulante);

        vista.mostrarMensaje("Postulante registrado correctamente.");
        vista.mostrarMensaje("Clave generada y enviada al email: " + clave);
    }

    public void registrarOferta() {
        String ruc = vista.leerTexto("Ingrese RUC del cliente empresa: ");

        Cliente cliente = arregloClientes.buscar(ruc);

        if (cliente == null) {
            vista.mostrarMensaje("No existe un cliente con ese RUC.");
            return;
        }

        String puesto = vista.leerTexto("Ingrese nombre del puesto: ");
        String descripcion = vista.leerTexto("Ingrese descripcion del puesto: ");
        String area = vista.leerTexto("Ingrese area de la empresa: ");

        Date fechaInicio = new Date();
        Date fechaTermino = new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000);

        Oferta oferta = new Oferta(
                puesto,
                descripcion,
                area,
                fechaInicio,
                fechaTermino
        );

        cliente.agregarOferta(oferta);
        arregloOfertas.agregar(oferta);

        vista.mostrarMensaje("Oferta registrada correctamente.");
    }

    public void agregarRequisitoOferta() {
        String puesto = vista.leerTexto("Ingrese puesto de la oferta: ");

        Oferta oferta = arregloOfertas.buscar(puesto);

        if (oferta == null) {
            vista.mostrarMensaje("No existe una oferta con ese puesto.");
            return;
        }

        int orden = vista.leerEntero("Ingrese orden del requisito: ");
        String descripcion = vista.leerTexto("Ingrese descripcion del requisito: ");

        boolean agregado = oferta.agregarRequisito(orden, descripcion);

        if (agregado) {
            vista.mostrarMensaje("Requisito agregado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo agregar el requisito.");
        }
    }

    public void postularAOferta() {
        String email = vista.leerTexto("Ingrese email del postulante: ");
        Postulante postulante = arregloPostulantes.buscar(email);

        if (postulante == null) {
            vista.mostrarMensaje("No existe un postulante con ese email.");
            return;
        }

        String puesto = vista.leerTexto("Ingrese puesto de la oferta: ");
        Oferta oferta = arregloOfertas.buscar(puesto);

        if (oferta == null) {
            vista.mostrarMensaje("No existe una oferta con ese puesto.");
            return;
        }

        if (!oferta.estaActiva()) {
            vista.mostrarMensaje("La oferta no esta activa.");
            return;
        }

        String rutaCV = vista.leerTexto("Ingrese nombre o ruta del CV: ");

        boolean resultado = postulante.postular(oferta, rutaCV);

        if (resultado) {
            vista.mostrarMensaje("Postulacion registrada correctamente.");
            vista.mostrarMensaje("CV adjuntado: " + rutaCV);
        } else {
            vista.mostrarMensaje("No se pudo registrar la postulacion. El CV es obligatorio.");
        }
    }

    public void anularPostulacion() {
        String email = vista.leerTexto("Ingrese email del postulante: ");
        Postulante postulante = arregloPostulantes.buscar(email);

        if (postulante == null) {
            vista.mostrarMensaje("No existe un postulante con ese email.");
            return;
        }

        Postulacion[] postulaciones = postulante.getPostulaciones();
        int cantidad = postulante.getCantidadPostulaciones();

        if (cantidad == 0) {
            vista.mostrarMensaje("El postulante no tiene postulaciones.");
            return;
        }

        vista.mostrarMensaje("\n===== POSTULACIONES =====");

        for (int i = 0; i < cantidad; i++) {
            String estado = postulaciones[i].isAnulado() ? "ANULADA" : "ACTIVA";
            vista.mostrarMensaje((i + 1) + ". "
                    + postulaciones[i].getOferta().getPuesto()
                    + " | Fecha: " + postulaciones[i].getFecha()
                    + " | Estado: " + estado
                    + " | CV: " + postulaciones[i].getRutaCV());
        }

        int numero = vista.leerEntero("Ingrese numero de postulacion a anular: ");

        if (numero < 1 || numero > cantidad) {
            vista.mostrarMensaje("Numero incorrecto.");
            return;
        }

        Postulacion postulacion = postulaciones[numero - 1];

        boolean resultado = postulante.anularPostulacion(postulacion);

        if (resultado) {
            vista.mostrarMensaje("Postulacion anulada correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo anular. Puede que ya este anulada.");
        }
    }

    public void listarOfertasActivas() {
        vista.mostrarMensaje("\n===== OFERTAS ACTIVAS =====");

        Oferta[] ofertas = arregloOfertas.getDatos();
        int cantidad = arregloOfertas.getIndice();
        boolean existe = false;

        for (int i = 0; i < cantidad; i++) {
            if (ofertas[i].estaActiva()) {
                vista.mostrarMensaje((i + 1) + ". "
                        + ofertas[i].getPuesto()
                        + " | Area: " + ofertas[i].getArea()
                        + " | Inicio: " + ofertas[i].getFechaInicio()
                        + " | Termino: " + ofertas[i].getFechaTermino());
                existe = true;
            }
        }

        if (!existe) {
            vista.mostrarMensaje("No hay ofertas activas.");
        }
    }

    public void listarPostulacionesPostulante() {
        String email = vista.leerTexto("Ingrese email del postulante: ");
        Postulante postulante = arregloPostulantes.buscar(email);

        if (postulante == null) {
            vista.mostrarMensaje("No existe un postulante con ese email.");
            return;
        }

        Postulacion[] postulaciones = postulante.getPostulaciones();
        int cantidad = postulante.getCantidadPostulaciones();

        if (cantidad == 0) {
            vista.mostrarMensaje("El postulante no tiene postulaciones.");
            return;
        }

        vista.mostrarMensaje("\n===== POSTULACIONES DEL POSTULANTE =====");

        for (int i = 0; i < cantidad; i++) {
            String estado = postulaciones[i].isAnulado() ? "ANULADA" : "ACTIVA";

            vista.mostrarMensaje((i + 1) + ". "
                    + postulaciones[i].getOferta().getPuesto()
                    + " | Fecha: " + postulaciones[i].getFecha()
                    + " | Estado: " + estado);

            vista.mostrarMensaje("   CV: " + postulaciones[i].getRutaCV());

            if (postulaciones[i].isAnulado()) {
                vista.mostrarMensaje("   Fecha de anulacion: "
                        + postulaciones[i].getFechaAnulacion());
            }
        }
    }

    public void listarRubros() {
        vista.mostrarMensaje("\n===== RUBROS REGISTRADOS =====");
        arregloRubros.listar();
    }

    public void listarClientes() {
        vista.mostrarMensaje("\n===== CLIENTES REGISTRADOS =====");
        arregloClientes.listar();
    }

    public void listarPostulantes() {
        vista.mostrarMensaje("\n===== POSTULANTES REGISTRADOS =====");
        arregloPostulantes.listar();
    }

    public void listarOfertas() {
        vista.mostrarMensaje("\n===== OFERTAS REGISTRADAS =====");
        arregloOfertas.listar();
    }
}