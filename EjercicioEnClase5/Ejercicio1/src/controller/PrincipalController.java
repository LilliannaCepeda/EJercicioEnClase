package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrincipalController {
    
   @FXML
   private TextField txtMontoDOP;

   @FXML
   private ComboBox<String> MonedaDestinoComboBox;

   @FXML
   private Label lblResultado;

   @FXML
   private Label lblMensaje;

   private static final double TASA_USD = 59.00;
   private static final double TASA_EUR =64.00;

   @FXML
   public void initialize(){
      MonedaDestinoComboBox.getItems().addAll("Dolar estadounidense", "Euro");
      lblMensaje.setText("Esperando informacion...");
   }

   @FXML 
   public void convertir(){
      String monto = txtMontoDOP.getText();
      String moneda = MonedaDestinoComboBox.getValue();

        if (monto == null || monto.isBlank()) {
            lblMensaje.setText("Debe ingresar un monto.");
            return;
         }

         double valorDOP;
         try{
            valorDOP = Double.parseDouble(monto);
         }catch(NumberFormatException e){
            lblMensaje.setText("EL monto debe ser un valor numerico.");
            return;
         }


        if (moneda == null) {
            lblMensaje.setText("Debe seleccionar una moneda.");
            return;
        }

        double resultado;
        String TipoMoneda;

        if (moneda.equals("Dolar estadounidense")) {
            resultado = valorDOP / TASA_USD;
            TipoMoneda = "USD";
        } else {
            resultado = valorDOP / TASA_EUR;
            TipoMoneda = "EUR";
        }

        lblResultado.setText(String.format("RD$ %,.2f equivale a %.2f %s", valorDOP, resultado, TipoMoneda));
        lblMensaje.setText("Conversión realizada con éxito.");
   }

     @FXML
    private void limpiar() {
        txtMontoDOP.clear();
        MonedaDestinoComboBox.getSelectionModel().clearSelection();
        lblResultado.setText("Resultado:");
        lblMensaje.setText("Esperando información...");
    }

    @FXML
    private void mostrarAyuda() {
        lblMensaje.setText("Presione para realizar la conversión.");
    }

    @FXML
    private void ocultarAyuda() {
        lblMensaje.setText("Esperando información...");
    }

}
