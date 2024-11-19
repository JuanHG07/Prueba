package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ConsultaSolicitudesController;
import co.edu.uniquindio.poo.model.EstadoTransaccion;
import co.edu.uniquindio.poo.model.Transaccion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ConsultaSolicitudesViewController {

    @FXML
    private TableView<Transaccion> tblSolicitudes;

    @FXML
    private TableColumn<Transaccion, String> clmCodigo;

    @FXML
    private TableColumn<Transaccion, String> clmCodigoVendedor;

    @FXML
    private TableColumn<Transaccion, String> clmFecha;

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnRechazar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtOferta;

    private App app;

    private ConsultaSolicitudesController consultaSolicitudesController;

    private ObservableList<Transaccion> transacciones;

    private String usuarioCliente;

    private Transaccion selectedTransaccion;

    @FXML
    void initialize() {
        consultaSolicitudesController = new ConsultaSolicitudesController(app.concesionario);
        transacciones = FXCollections.observableArrayList();
        clmCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clmFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        clmCodigoVendedor.setCellValueFactory(cellData -> {

        Transaccion transaccion = cellData.getValue();
        if (transaccion.getVendedor() != null) {
            return new SimpleStringProperty(transaccion.getVendedor().getCodigoEmpleado());
        } else {
            return new SimpleStringProperty("Sin vendedor");
        }
        });

      
        tblSolicitudes.setItems(transacciones);
    }

    @FXML
    void aceptarOferta(ActionEvent event) {
        Transaccion transaccionSeleccionada = tblSolicitudes.getSelectionModel().getSelectedItem();
        selectedTransaccion = transaccionSeleccionada;

        if (transaccionSeleccionada != null) {
            if (transaccionSeleccionada.getEstadoTransaccion() == EstadoTransaccion.PENDIENTE) {
                consultaSolicitudesController.aceptarTransaccion(transaccionSeleccionada);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Transacción aceptada correctamente.");
                cargarTransaccionesCliente(); 
            } else {
                mostrarAlerta(Alert.AlertType.WARNING, "Advertencia",
                        "Solo se pueden aceptar transacciones pendientes.");
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Debe seleccionar una transacción.");
        }
    }

    @FXML
    void rechazarOferta(ActionEvent event) {
        Transaccion transaccionSeleccionada = tblSolicitudes.getSelectionModel().getSelectedItem();
        selectedTransaccion=transaccionSeleccionada;

        if (transaccionSeleccionada != null) {
            if (transaccionSeleccionada.getEstadoTransaccion() == EstadoTransaccion.PENDIENTE) {
                consultaSolicitudesController.rechazarTransaccion(transaccionSeleccionada);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Transacción rechazada correctamente.");
                cargarTransaccionesCliente(); 
            } else {
                mostrarAlerta(Alert.AlertType.WARNING, "Advertencia",
                        "Solo se pueden rechazar transacciones pendientes.");
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Debe seleccionar una transacción.");
        }
    }

    private void cargarTransaccionesCliente() {
        usuarioCliente = app.getLoginViewController().getUsuario();
        if (usuarioCliente != null) {
            List<Transaccion> listaTransacciones = consultaSolicitudesController
                    .obtenerTransaccionesCliente(usuarioCliente);

            List<Transaccion> transaccionesPendientes = new ArrayList<>();

            for (Transaccion transaccion : listaTransacciones) {
                if (transaccion.getEstadoTransaccion() == EstadoTransaccion.PENDIENTE) {
                    transaccionesPendientes.add(transaccion);
                }
            }

            transacciones.setAll(transaccionesPendientes); 
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo identificar al cliente logueado.");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
