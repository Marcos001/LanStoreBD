package com.CraftSoft.MV;

import java.awt.*;
import java.sql.*;

import com.CraftSoft.MV.Socket.*;
import com.CraftSoft.MV.GUI.*;

import javax.swing.JPanel;

/**
 * Created by nig on 24/01/17.
 */


public class mvLaucher{

    /**-------------VARIAVEIS---------------*/

    private Servidor s;

    private JPanel painelMain;





    /**-------------FUNCOES---------------*/

    private void print(String msg){
        System.out.println(msg);
    }


    /**------------funcao para instanciar e configurar SERVIDOR----------------*/


    private JPanel testeServidor(){

        System.out.println("Criado servidor");

        s = new Servidor();
        s.runServer();


        System.out.println("End Aplication.");


        return s;
    }



    /**-----------funcao para instanciar e conffigurar CLIENTE----------------*/

    private void testeCliente(String[] a) {

        //---Cliente application; // declare client application

        //---print("Valor de a = "+a.length);

        // if no command line args
        if ( a.length == 0 ) {
            //---application = new Cliente( "127.0.0.1" ); // connect to localhost
            //---print( "conectado em localhost" );
        }
        else{
            //---application = new Cliente( a[ 0 ] ); // use args to connect
            //---print( "conectado em com ip = " + a );
        }

        //---application.runClient(); // run client application

        //janela = new Janela(application, "",300,300);

    }




    private void conexaoBancoMysql(){

        String linhas = "";
        String fim = "\n--------------------------------------";
        String spd = " :: ";
        String mais = " + ";

        String url = "jdbc:mysql://localhost/estacionamento";


        try{

            java.sql.Connection conexao =  DriverManager.getConnection(url,"root","root");
            PreparedStatement pesquisa = (PreparedStatement) conexao.prepareStatement("SELECT * FROM cliente");
            ResultSet resultado = pesquisa.executeQuery();

            while(resultado.next()){
                linhas = linhas +"\nCPF = "+ resultado.getString("cpf_cli")+mais+
                                 " Nome = "+ resultado.getString("nome_cli")+mais+
                                 " Data Nascismento = "+ resultado.getString("data_nasc")+spd+fim;

            }


        }catch(Exception erro){
            linhas = "Nao ADD";
        }


        System.out.println(linhas);

    }


    private void adicionarPainelMain(){

        panel painelIp = new panel();

        painelMain = new JPanel();
        painelMain.setLayout(null);
        painelMain.setBackground(new Color(255,255,255));
        painelMain.setSize(500,350);

        painelMain.add(painelIp.init_painelIpPorta(500,350));
        painelMain.add(s);
        painelMain.add(painelIp.init_painelEnvio(500,300));



        new windows(painelMain,"Servidor");

    }


    /**-----------------CONSTRUTOR--------------------*/

    public mvLaucher(){

        conexaoBancoMysql();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                adicionarPainelMain();
            }
        });




        testeServidor();

    }


} //fim da classe
