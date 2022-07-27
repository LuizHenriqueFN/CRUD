package com.crud.luiz.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco_De_Dados {
    Connection Con = null;
    String url = "jdbc:mariadb://localhost:3306";
    String usuario = "root";
    String senha = "1234";

    public Connection getConnection(){
        if(Con == null){
            try {
                Con = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return Con;
        }
        else return Con;

        
    }
}
