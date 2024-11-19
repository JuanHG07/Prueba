package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ConsultaTransaccionController;
import co.edu.uniquindio.poo.controller.DatosAlquilerController;
import co.edu.uniquindio.poo.model.Transaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;

public class DatosAlquilerViewController {
    @FXML
    private Button btnSalir;

    @FXML
    private DatePicker datepckFechaInicial;

    @FXML
    private Button btnAceptar;

    @FXML
    private DatePicker datepckFechaFinal;

    private App app;

    DatosAlquilerController datosAlquilerController;

    @FXML
    void initialize() {
        datosAlquilerController = new DatosAlquilerController(app.concesionario);
    }

    @FXML
    void guardarNegocioAlquiler(ActionEvent event) {
        Transaccion transaccion = app.getConsultaSolicitudesViewController();
    }

    @FXML
    void regresarCliente(ActionEvent event) {

    }

    public void setApp(App app) {
        this.app = app;
    }

}
