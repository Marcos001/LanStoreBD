package com.CraftSoft.MV.DATABASE;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by rmx on 26/01/17.
 */
public class DataBase {


    private void inserirAoBanco(String comandosql){

        String linhas = "";

        String url = "jdbc:mysql://localhost/estacionamento";


        try{

            java.sql.Connection conexao =  DriverManager.getConnection(url,"root","root");

            /**----  executa o comando sql para insercao*/

            PreparedStatement pesquisa = (PreparedStatement) conexao.prepareStatement(comandosql);
            pesquisa.execute();



        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro de sintaxe SQL","Alerta!",JOptionPane.ERROR_MESSAGE);
        }


        System.out.println(linhas);
    }

    public DataBase(String comandosql){

        inserirAoBanco(comandosql);


    }




}
