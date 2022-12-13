package com.example.tiktaktoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TikTakToeController implements Initializable {


    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Text winnerText;

    //Recogeremos en una variable el turno de cada uno de los jugadores
    private int turno = 0;

    //Almacenaremos los botones en un array, los almaceno para llamarlos en el setup de una
    ArrayList<Button> botones;

    //Inicializamos el juego con el metodo inicialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Indicamos lo que contiene ese array de botones
        botones = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        //Llamaremos a cada boton
        botones.forEach(button -> {
            setUpButton(button);
            button.setFocusTraversable(false);
        });
    }

    private void setUpButton(Button button) {
        //Cogemos el boton y le añadimos el setonmouse
        button.setOnMouseClicked(mouseEvent -> {
            //Cuando clicamos el boton, cambiamos el simbolo del jugador X o 0
            cambiarJugador(button);
            //Desabilitaremos el boton para no cliclar +
            button.setDisable(true);
            //Comprobar si se gana
            comprobarGanador();
        });
    }

    private void comprobarGanador() {
        //Comprueba linea a linea, en las direcciones del tablero si los valores son iguales
        for(int i = 0; i < 8; i++ ){
            String linea = switch (i){
                //Comprobaciones horizontales
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                //Comprobaciones diagonales
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                //Comprobaciones verticales
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                //Ora opcion
                default -> null;
            };
            //En el caso de que gane aguien, mostrarlo por pantalla y parar el programa
            if(linea.equals("XXX")){ //Si la linea que se forma es de 3X juntas
                winnerText.setText("Jugador 1 (X) gana");
            }
            if(linea.equals("000")){
                winnerText.setText("Jugador 2 (0) gana");
            }
        }
    }

    private void cambiarJugador(Button button) {
        //Alternar entre jugadores
        if(turno % 2 == 0){
            button.setText("X");
            //Seteamos el turno al primer jugador
            turno = 1;
        }else{
            button.setText("0");
            turno = 0;
        }
    }

    public void restartGame(ActionEvent actionEvent) {
        //Este es el boton que hay en la interfaz y llama al reseteo en cada uno de los botones
        botones.forEach(this::resetButton);
        winnerText.setText("Tic - Tac - Toe");
    }

    private void resetButton(Button button) {
        //Esto lo que hace es volver a la normalidad las cosas
        button.setDisable(true);
        button.setText(" ");
    }


}