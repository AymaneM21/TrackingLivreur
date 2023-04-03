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

public class ProduitsController implements Initializable {
    @FXML
    private TextField nomprod ;
    @FXML
    private TextField prixuni ;

    @FXML
    private TextField quant ;

    @FXML
    private TableView<Produit> mytable3 ;








    @FXML
    private TableColumn<Produit ,String> col_nomprod ;

    @FXML
    private TableColumn <Produit ,String> col_prixuni ;

    @FXML
    private TableColumn <Produit ,String> col_quant ;




    @FXML
    protected void onSaveButtonClick3() {

        // accees a la bdd

        try {
            ProduitDAO produitDAO = new ProduitDAO();

            Produit com = new Produit(nomprod.getText(), prixuni.getText() , quant.getText());

            produitDAO.save(com);


            UpdateTable3();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    private AnchorPane produitpane ;
    @FXML
    protected void RetourMenu(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        produitpane.getChildren().setAll(pane);
    }


    public void UpdateTable3(){
        col_nomprod.setCellValueFactory(new PropertyValueFactory<Produit,String>("nomProduit"));
        col_prixuni.setCellValueFactory(new PropertyValueFactory<Produit,String>("prixUnitaire"));

        col_quant.setCellValueFactory(new PropertyValueFactory<Produit,String>("quantité"));

        mytable3.setItems(this.getDataProduits());
    }

    public static ObservableList<Produit> getDataProduits(){

        ProduitDAO produitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            produitDAO = new ProduitDAO();
            for (Produit ettemp : produitDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        UpdateTable3();
    }
}
