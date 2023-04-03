package com.example.trackinglivreur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProduitDAO extends BaseDAO<Produit>{
    public ProduitDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Produit object) throws SQLException {

        String request = "insert into produit (nom_Produit , Prix_Unitaire, Quantité) values (? , ? , ?)";

        // mapping objet table

        this.preparedStatement = this.conn.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNomProduit());

        this.preparedStatement.setString(2 , object.getPrixUnitaire());

        this.preparedStatement.setString(3 , object.getQuantité());

        this.preparedStatement.execute();
    }

    @Override
    public void update(Produit object) throws SQLException {

    }

    @Override
    public void delete(Produit object) throws SQLException {

    }

    @Override
    public List<Produit> getAll()  throws SQLException {

        List<Produit> mylist = new ArrayList<Produit>();

        String request = "select * from produit ";

        this.statement = this.conn.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Produit(this.resultSet.getString(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));


        }


        return mylist;
    }

    @Override
    public Produit getOne(Long id) throws SQLException {
        return null;
    }
}
