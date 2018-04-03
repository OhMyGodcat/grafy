/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafy;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class Knot implements Serializable
{
    int id;
    Color kolor;
    int x;
    int y;

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Color getKolor()
    {
        return kolor;
    }

    public Knot(int id, Color kolor, int x, int y)
    {
        this.id = id;
        this.kolor = kolor;
        this.x = x;
        this.y = y;
    }

    public void setKolor(Color kolor)
    {
        this.kolor = kolor;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    /*@Override
    public String toString()
    {
        return "Knot{" + "id=" + id + ", kolor=" + kolor + ", x=" + x + ", y=" + y + '}';
    }*/
    
    
    
    
    
}
