package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.EstadoTransaccion;
import co.edu.uniquindio.poo.model.Transaccion;

import java.util.List;

public class ConsultaSolicitudesController {

    private Concesionario concesionario;

    public ConsultaSolicitudesController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

  
    public Cliente obtenerClientePorUsuario(String usuario) {
        return concesionario.verificarClienteUsuario(usuario); 
    }

   
    public List<Transaccion> obtenerTransaccionesCliente(String usuario) {
        Cliente cliente = obtenerClientePorUsuario(usuario);
        if (cliente != null) {
            return cliente.getTransacciones(); 
        }
        return List.of(); 
    }

    public void aceptarTransaccion(Transaccion transaccion) {
    if (transaccion != null && transaccion.getEstadoTransaccion() == EstadoTransaccion.PENDIENTE) {
        transaccion.setEstadoTransaccion(EstadoTransaccion.ACEPTADA);
    } else {
        throw new IllegalArgumentException("La transacción no es válida o no está en estado PENDIENTE.");
    }
}
// rechazar

public void rechazarTransaccion(Transaccion transaccion) {
    if (transaccion != null && transaccion.getEstadoTransaccion() == EstadoTransaccion.PENDIENTE) {
        transaccion.setEstadoTransaccion(EstadoTransaccion.RECHAZADA);
    } else {
        throw new IllegalArgumentException("La transacción no es válida o no está en estado PENDIENTE.");
    }
}
}
