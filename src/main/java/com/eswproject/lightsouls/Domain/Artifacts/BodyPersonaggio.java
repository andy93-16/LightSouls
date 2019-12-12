package com.eswproject.lightsouls.Domain.Artifacts;

public enum BodyPersonaggio {
    ManoDestra("Arma"),
    ManoSinistra("Arma"),
    Corpo("Armatura");

    private String EqType;
    BodyPersonaggio(String EqType) {
        this.EqType=EqType;
    }

    public String getEqType() {
        return EqType;
    }
}
