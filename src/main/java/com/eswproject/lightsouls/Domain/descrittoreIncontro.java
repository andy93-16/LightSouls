package com.eswproject.lightsouls.Domain;

import javax.persistence.*;

@Entity
public class descrittoreIncontro {

    @Id
    private Long idDescrittoreIncontro;

    public Long getIdDescrittoreIncontro() {
        return idDescrittoreIncontro;
    }

    public void setIdDescrittoreIncontro(long idDescrittoreIncontro) {
        this.idDescrittoreIncontro = idDescrittoreIncontro;
    }



}