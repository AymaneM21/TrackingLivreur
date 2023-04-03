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


public class CommandesController implements Initializable {
    @FXML
    private TextField dateliv ;
    @FXML
    private TextField prixtot ;


    @FXML
    private TableView<Commande> mytable2 ;








    @FXML
    private TableColumn<Commande ,Integer> col_num ;

    @FXML
    private TableColumn <Commande ,String> col_dateliv ;

    @FXML
    private TableColumn <Commande ,String> col_prixtot ;




    @FXML
    protected void onSaveButtonClick2() {

        // accees a la bdd

        try {
            CommandeDAO commandeDAO = new CommandeDAO();

            Commande com = new Commande(0, dateliv.getText() , prixtot.getText());

            commandeDAO.save(com);


            UpdateTable2();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    private AnchorPane commandepane ;
    @FXML
    protected void RetourMenu(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        commandepane.getChildren().setAll(pane);
    }


    public void UpdateTable2(){
        col_num.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("numéroCommande"));
        col_dateliv.setCellValueFactory(new PropertyValueFactory<Commande,String>("dateLivraison"));

        col_prixtot.setCellValueFactory(new PropertyValueFactory<Commande,String>("prixTotal"));

        mytable2.setItems(this.getDataCommandes());
    }

    public static ObservableList<Commande> getDataCommandes(){

        CommandeDAO commandeDAO = null;

        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            commandeDAO = new CommandeDAO();
            for (Commande ettemp : commandeDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

           UpdateTable2();
    }
}
