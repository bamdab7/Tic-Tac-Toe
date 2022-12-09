package com.example.tiktaktoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TikTakToeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}