package com.CraftSoft.MV.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nig on 23/01/17.
 */
public class windows extends JFrame{


    public windows(){
        /**-- Construtor padrão caso nenhu parâmetro seja informado*/
    }


    public windows(JPanel painel,  String title){

        System.out.println("iniciando janela");

        System.out.println(" largura = "+painel.getWidth() + " \n altura = " +painel.getHeight());

        this.add(painel);
        this.setTitle(title);
        this.setLayout(new GridLayout(1,1));
        this.setSize(painel.getWidth(),painel.getHeight());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        super.setVisible(true);

    }


}
