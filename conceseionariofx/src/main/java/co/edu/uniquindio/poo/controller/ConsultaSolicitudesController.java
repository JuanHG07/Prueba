package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
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
}
