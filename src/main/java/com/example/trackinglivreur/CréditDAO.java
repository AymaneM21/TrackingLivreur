package com.example.trackinglivreur;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CréditDAO extends BaseDAO<Crédit>{
    public CréditDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Crédit object) throws SQLException {

        String request = "insert into crédit (Montant , Duree_crédit , Etat_crédit) values (? , ? , ?)";

        // mapping objet table

        this.preparedStatement = this.conn.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getMontant());

        this.preparedStatement.setString(2 , object.getDureecredit());

        this.preparedStatement.setString(3 , object.getEtatcredit());

        this.preparedStatement.execute();
    }

    @Override
    public void update(Crédit object) throws SQLException {

    }

    @Override
    public void delete(Crédit object) throws SQLException {

        String request = "DELETE FROM crédit WHERE Montant = ?";

        // mapping objet table

        this.preparedStatement = this.conn.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getMontant());




        this.preparedStatement.execute();
    }

    @Override
    public List<Crédit> getAll()  throws SQLException {

        List<Crédit> mylist = new ArrayList<Crédit>();

        String request = "select * from crédit ";

        this.statement = this.conn.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Crédit(this.resultSet.getString(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));


        }


        return mylist;
    }

    @Override
    public Crédit getOne(Long id) throws SQLException {
        return null;
    }


}
