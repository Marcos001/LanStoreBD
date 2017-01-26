package com.CraftSoft.Ivan.Controle;


import com.CraftSoft.Ivan.Controle.*;
import com.CraftSoft.Ivan.GUI.*;

/**
 * Created by ivan21 on 24/01/17.
 */

public class Handler {

    private Janela janela_principal;
    private Gerenciador gerenciador;

    public Handler(Janela j) {
        this.janela_principal = j;
    }

    public Janela getJanela_principal() {return janela_principal;}
}
