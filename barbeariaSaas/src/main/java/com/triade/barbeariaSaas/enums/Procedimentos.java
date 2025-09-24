package com.triade.barbeariaSaas.enums;


public enum Procedimentos {
    CORTE(30),
    BARBA(20),
    SOBRANCELHA(15);

    private final int tempoProcedimento; // minutos

    Procedimentos(int tempoProcedimento) {
        this.tempoProcedimento = tempoProcedimento;
    }

    public int getTempoProcedimento() {
        return tempoProcedimento;
    }
}
