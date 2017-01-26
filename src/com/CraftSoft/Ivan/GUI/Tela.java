package com.CraftSoft.Ivan.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ivan21 on 24/01/17.
 */

public abstract class Tela extends JPanel {

    public Tela(int largura, int altura) {
        setSize(largura, altura);
        setLayout(null);
        setBackground(Color.WHITE);
    }
}
