package com.eswproject.lightsouls.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class descrittoreDungeon {

    public void setBossName(String bossName) {
        BossName = bossName;
    }

    @Id
    String BossName;

}