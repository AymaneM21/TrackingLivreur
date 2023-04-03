package com.example.trackinglivreur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CommandeDAO extends BaseDAO<Commande>{
    public CommandeDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Commande object) throws SQLException {

        String request = "insert into commande (Date_Livraison , Prix_Total) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.conn.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getDateLivraison());

        this.preparedStatement.setString(2 , object.getPrixTotal());



        this.preparedStatement.execute();
    }

    @Override
    public void update(Commande object) throws SQLException {

    }

    @Override
    public void delete(Commande object) throws SQLException {

        String request = "DELETE FROM commande WHERE N_Commande = ?";

        // mapping objet table

        this.preparedStatement = this.conn.prepareStatement(request);
        // mapping
        this.preparedStatement.setInt(1 , object.getNuméroCommande());




        this.preparedStatement.execute();
    }

    @Override
    public List<Commande> getAll()  throws SQLException {

        List<Commande> mylist = new ArrayList<Commande>();

        String request = "select * from commande ";

        this.statement = this.conn.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Commande(this.resultSet.getInt(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));


        }


        return mylist;
    }

    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }


}
