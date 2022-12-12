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
        });
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
        
    }


}