package com.example.trackinglivreur;

import java.sql.*;
import java.util.List;

public abstract class BaseDAO <T> {

    protected Connection conn ;
    protected Statement statement ;

    protected PreparedStatement preparedStatement;

    protected ResultSet resultSet ;

    // connexion  bdd

    private String url = "jdbc:mysql://localhost:3306/tracking";
    private String login = "root";
    private String password = "";



    BaseDAO() throws SQLException {
        this.conn = DriverManager.getConnection(url , login ,password );
    }


    public abstract void save( T object ) throws SQLException;

    public abstract void update( T object ) throws SQLException ;

    public abstract void delete(T object) throws SQLException ;


    public abstract List<T> getAll(  ) throws SQLException ;


    public abstract T getOne( Long id  ) throws SQLException  ;

}
