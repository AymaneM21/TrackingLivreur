package com.example.trackinglivreur;
import  javafx.collections.FXCollections;
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
public class LivreursController implements Initializable{
    @FXML
    private TextField nom ;


    @FXML
    private TextField tele ;


    @FXML
    private TableView<Livreur> mytable1 ;


    @FXML
    private TableColumn<Livreur ,Long> col_id ;

    @FXML
    private TableColumn <Livreur ,String> col_nom ;

    @FXML
    private TableColumn <Livreur ,String> col_tele ;


    @FXML
    protected void onSaveButtonClick1() {

        // accees a la bdd

        try {
            LivreurDAO livreurDAO = new LivreurDAO();

            Livreur liv = new Livreur(0 , nom.getText() , tele.getText());

            livreurDAO.save(liv);


            UpdateTable1();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable1(){
        col_id.setCellValueFactory(new PropertyValueFactory<Livreur,Long>("id_livreur"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("nom"));

        col_tele.setCellValueFactory(new PropertyValueFactory<Livreur,String>("telephone"));



        mytable1.setItems(this.getDataLivreurs());
    }

    public static ObservableList<Livreur> getDataLivreurs(){

        LivreurDAO livreurDAO = null;

        ObservableList<Livreur> listfx = FXCollections.observableArrayList();

        try {
            livreurDAO = new LivreurDAO();
            for (Livreur ettemp : livreurDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }
    @FXML
    private AnchorPane livreurpane ;
    @FXML
    protected void RetourMenu(ActionEvent event) throws IOException {

        AnchorPane pane  = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        livreurpane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable1();

    }
}
