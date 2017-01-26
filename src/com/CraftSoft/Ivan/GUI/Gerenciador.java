package com.CraftSoft.Ivan.GUI;

import com.CraftSoft.Ivan.Controle.Handler;



/**
 * Created by ivan21 on 24/01/17.
 */

public class Gerenciador {

    Tela tela1;
    private Handler handler;

    public Gerenciador(String t, int l, int a) {

        tela1 = new TelaInicial(320, 240);
        handler = new Handler(new Janela(tela1, t, l, a));

    }

}
