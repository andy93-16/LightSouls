package com.eswproject.lightsouls.Domain;

import javax.persistence.*;

@Entity
public class descrittoreIncontro implements Cloneable
{

    @Id
    private Long idDescrittoreIncontro;

    public Long getIdDescrittoreIncontro() {
        return idDescrittoreIncontro;
    }

    public void setIdDescrittoreIncontro(long idDescrittoreIncontro) {
        this.idDescrittoreIncontro = idDescrittoreIncontro;
    }

    @Override
    public descrittoreIncontro clone() {
        try {
            return (descrittoreIncontro) super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

}