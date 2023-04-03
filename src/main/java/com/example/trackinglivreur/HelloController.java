package com.example.trackinglivreur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.trackinglivreur.Livreur;
import com.example.trackinglivreur.LivreurDAO;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {




           @FXML
           private AnchorPane dashboardpane ;
    @FXML
    protected void AfficherLivreurs(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        dashboardpane.getChildren().setAll(pane);
    }
    @FXML
    protected void AfficherCommandes(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("commandes.fxml"));
        dashboardpane.getChildren().setAll(pane);
    }
    @FXML
    protected void AfficherProduits(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("produits.fxml"));
        dashboardpane.getChildren().setAll(pane);
    }
    @FXML
    protected void AfficherCrédits(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("crédits.fxml"));
        dashboardpane.getChildren().setAll(pane);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}