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
import com.example.trackinglivreur.Commande;
import com.example.trackinglivreur.CommandeDAO;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CréditsController implements Initializable{
    @FXML
    private TextField mont ;
    @FXML
    private TextField duree ;

    @FXML
    private TextField etat ;

    @FXML
    private TableView<Crédit> mytable4 ;








    @FXML
    private TableColumn<Crédit ,String> col_mont ;

    @FXML
    private TableColumn <Crédit ,String> col_duree ;

    @FXML
    private TableColumn <Crédit ,String> col_etat ;




    @FXML
    protected void onSaveButtonClick4() {

        // accees a la bdd

        try {
            CréditDAO créditDAO = new CréditDAO();

            Crédit com = new Crédit(mont.getText(), duree.getText() , etat.getText());

            créditDAO.save(com);


            UpdateTable4();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    private AnchorPane créditpane ;
    @FXML
    protected void RetourMenu(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        créditpane.getChildren().setAll(pane);
    }


    public void UpdateTable4(){
        col_mont.setCellValueFactory(new PropertyValueFactory<Crédit,String>("montant"));
        col_duree.setCellValueFactory(new PropertyValueFactory<Crédit,String>("dureecredit"));

        col_etat.setCellValueFactory(new PropertyValueFactory<Crédit,String>("etatcredit"));

        mytable4.setItems(this.getDataCrédits());
    }

    public static ObservableList<Crédit> getDataCrédits(){

        CréditDAO créditDAO = null;

        ObservableList<Crédit> listfx = FXCollections.observableArrayList();

        try {
            créditDAO = new CréditDAO();
            for (Crédit ettemp : créditDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        UpdateTable4();
    }
}
