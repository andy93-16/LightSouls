package com.eswproject.lightsouls.Domain.Dice;

import java.util.Random;

public class Dice
{
    protected int total_Faces;
    protected int[] values;

    public int throw_Dice()
    {
        return this.get_Element(new Random().nextInt(this.getTotal_Faces()));
    }

    private int getTotal_Faces()
    {
        return this.values.length;
    }

    private int get_Element(int i)
    {
        return values[i];
    }
}
