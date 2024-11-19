package co.edu.uniquindio.poo.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConsultaSolicitudesViewController {
    @FXML
    private TableColumn<?, ?> clmCodigo;

    @FXML
    private RadioButton radioCompra;

    @FXML
    private TableView<?> tblSolicitudes;

    @FXML
    private TableColumn<?, ?> ClmCodigoVendedor;

    @FXML
    private Button btnAceptar;

    @FXML
    private TableColumn<?, ?> clmFecha;

    @FXML
    private Button btnRechazar;

    @FXML
    private RadioButton radioAlquiler;

    @FXML
    private Button btnCancelar;

    @FXML
    private RadioButton radioVenta;

    @FXML
    private TextField txtOferta;

    @FXML
    void aceptarOferta(ActionEvent event) {

    }

    @FXML
    void regresarCliente(ActionEvent event) {

    }

    @FXML
    void rechazarOferta(ActionEvent event) {

    }
}
