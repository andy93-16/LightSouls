package com.eswproject.lightsouls.Domain;

import javax.persistence.*;

@Entity
public class descrittoreIncontro {

    @Id
    Long idDescrittoreIncontro;

    public void setIdDescrittoreIncontro(long idDescrittoreIncontro) {
        this.idDescrittoreIncontro = idDescrittoreIncontro;
    }



}