package com.eswproject.lightsouls.Domain.Dice;

import java.util.Random;

public class Dice
{
    private int[] black = new int[]{0, 0, 1, 1, 1, 2};
    private int[] blue = new int[]{1, 1, 2, 2, 2, 3};
    private int[] orange = new int[]{1, 2, 2, 2, 3, 4};
    private int[] green = new int[]{0, 0, 1, 1, 2, 2};

    private static Dice obj;

    private Dice() {}

    public static Dice getInstance()
    {
        if (obj==null)
            obj = new Dice();
        return obj;
    }

    private int throw_Dice(DiceColor color)
    {
        int face;
        switch(color)
        {
            case BLACK:
                face = this.black[new Random().nextInt(this.black.length)];
                break;

            case BLUE:
                face = this.blue[new Random().nextInt(this.blue.length)];
                break;

            case ORANGE:
                face = this.orange[new Random().nextInt(this.orange.length)];
                break;

            case GREEN:
                face = this.green[new Random().nextInt(this.green.length)];
                break;

            default: //Like BLACK
                face = this.black[new Random().nextInt(this.black.length)];
                break;

        }
        return face;
    }

    public int throw_Dice(DiceColor color, int numeroTiri)
    {
        int total = 0;
        for(int i = 0; i < numeroTiri; i++)
        {
            total += this.throw_Dice(color);
        }
        return total;
    }

}
