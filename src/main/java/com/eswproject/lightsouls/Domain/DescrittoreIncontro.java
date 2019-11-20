package com.eswproject.lightsouls.Domain;

import javax.persistence.*;

@Entity
public class DescrittoreIncontro implements Cloneable
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
    public DescrittoreIncontro clone() {
        try {
            return (DescrittoreIncontro) super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

}