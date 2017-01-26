package com.CraftSoft.Ivan.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ivan21 on 24/01/17.
 */
public class TelaInicial extends Tela {

    private JTextField enterField; // enters information from user
    private JTextArea displayArea; // display information to user
    private String message = ""; // message from server
    private String chatServer; // host server for this application

    public TelaInicial(int largura, int altura) {
        super(largura, altura);
        configurarComponentes();
    }

    private void configurarComponentes() {

        enterField = new JTextField();
        enterField.setEditable(false);
        enterField.setBounds(100, 100, 100, 30);
        add(enterField);

        displayArea = new JTextArea();
        displayArea.setEnabled(false);
        JScrollPane jsp = new JScrollPane(displayArea);
        jsp.setBounds(100, 200, 200, 100);
        add(jsp);
    }
}
