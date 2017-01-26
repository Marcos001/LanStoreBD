package com.CraftSoft.Ivan.GUI;



import javax.swing.*;

/**
 * Created by nig on 23/01/17.
 */

public class Janela extends JFrame{

    private Tela telaAtual;

    public Janela(Tela tela, String titulo, int largura, int altura) {
        telaAtual = tela;
        add(telaAtual);
        setTitle(titulo);
        setSize(largura, altura);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void alterarTela(JPanel novaTela) {
        setVisible(false);
        remove(telaAtual);
        add(novaTela);
        setVisible(true);
    }
}
