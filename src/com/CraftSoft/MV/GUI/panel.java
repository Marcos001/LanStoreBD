package com.CraftSoft.MV.GUI;

import javax.swing.*;
import java.awt.*;

import com.CraftSoft.MV.NET.*;

/**
 * Created by nig on 25/01/17.
 */


public class panel  {


    JPanel painelIpPorta;
    JPanel painelEnvio;

    private void print(String m){
        System.out.println(m);
    }


    public JPanel init_painelIpPorta(int tw, int th){

        rede net = new rede();


        int scala = 4;
        int altura = 40;

        //configuracao do painel

        painelIpPorta = new JPanel();
        painelIpPorta.setLayout(null);
        painelIpPorta.setBackground(new Color(255,255,255));
        painelIpPorta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 150, 150), 1, true));
        painelIpPorta.setBounds(scala,scala,(tw-(scala*2)),altura);


        JTextField tf_ip = new JTextField(""+net.str_ip);
        int larg_tf_ip = 100;
        tf_ip.setEnabled(false);
        tf_ip.setBounds(scala,scala,(larg_tf_ip),(altura-(scala*2)));
        painelIpPorta.add(tf_ip);


        JTextField tf_porta = new JTextField(""+net.porta);
        int larg_tf_porta = 100;
        int posicao_x_tf_porta = tf_ip.getWidth()+(scala*2);
        tf_porta.setEnabled(false);
        tf_porta.setBounds(posicao_x_tf_porta,scala,(larg_tf_porta),(altura-(scala*2)));
        painelIpPorta.add(tf_porta);


        JButton bt_alterar = new JButton("Alterar");
        bt_alterar.setBackground(new Color(255,255,255));
        int tam_bt_alterar = 100;
        //int posicao_x_bt_alterar = (posicao_x_tf_porta + tf_porta.getWidth()) +(scala*2);
        int posicao_x_bt_alterar = (painelIpPorta.getWidth() - (scala + tam_bt_alterar));
        print("Tamanho do painel = "+painelIpPorta.getWidth() +" scala = "+scala + "tamanho bt = " +tam_bt_alterar);
        bt_alterar.setBounds(posicao_x_bt_alterar,scala,(tam_bt_alterar),(altura-(scala*2)));
        painelIpPorta.add(bt_alterar);

        return painelIpPorta;
    }



    public JPanel init_painelEnvio(int tw, int th){

        painelEnvio = new JPanel();
        int scala = 4;
        int altura = 40;

        //configuracao do painel

        painelEnvio = new JPanel();
        painelEnvio.setLayout(null);
        painelEnvio.setBackground(new Color(255,255,255));
        painelEnvio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 150, 150), 1, true));
        painelEnvio.setBounds(scala,(th - (scala)),(tw-(scala*2)),altura);


        return painelEnvio;
    }


    public panel(){

    }


}
