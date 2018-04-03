/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafy;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Edge implements Serializable
{
    int id;
    int kierunek; //-1 <-   0 <->   1 ->
    int waga;
    int szerokosc;

    public Edge(int id, int kierunek, int waga, Knot k1, Knot k2)
    {
        this.id = id;
        this.kierunek = kierunek;
        this.waga = waga;
        this.k1 = k1;
        this.k2 = k2;
        this.szerokosc = 1;
    }
    Knot k1;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getKierunek()
    {
        return kierunek;
    }

    public void setKierunek(int kierunek)
    {
        this.kierunek = kierunek;
    }

    public int getWaga()
    {
        return waga;
    }

    public void setWaga(int waga)
    {
        this.waga = waga;
    }

    public Knot getK1()
    {
        return k1;
    }

    public void setK1(Knot k1)
    {
        this.k1 = k1;
    }

    public Knot getK2()
    {
        return k2;
    }

    public void setK2(Knot k2)
    {
        this.k2 = k2;
    }
    Knot k2;

    public int getSzerokosc()
    {
        return szerokosc;
    }

    public void setSzerokosc(int szerokosc)
    {
        this.szerokosc = szerokosc;
    }

    
    @Override
    public String toString()
    {
        return "Edge{" + "id=" + id + ", kierunek=" + kierunek + ", waga=" + waga + ", k1=" + k1 + ", k2=" + k2 + '}';
    }
    
}
