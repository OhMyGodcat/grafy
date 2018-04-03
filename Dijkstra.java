/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafy;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Dijkstra
{
  DijkstraResult Wynik;
    public Dijkstra(ArrayList<Knot> KnotList, ArrayList<Edge> EdgeList, Integer start, Integer koniec)
    {
        Wynik = new DijkstraResult(KnotList.size());
       
        Wynik.Odleglosci.set(start, 0); //Start to wartość z tekstu, w którym zaczynamy liczenie od 1      
    }
    DijkstraResult CalcDijkstra(ArrayList<Knot> KnotList, ArrayList<Edge> EdgeList, Integer start, Integer koniec)
    {
        
        while (Wynik.Odleglosci.get(koniec) == 65000)
                {
                    int sprawdzana = 65000;
                    int sprawdz_id = 0;
                    for (int i = 0; i < KnotList.size(); i++)
                    {
                        if(Wynik.checked.get(i) == false)
                        {
                                if(Wynik.Odleglosci.get(i) < sprawdzana)
                            {
                                sprawdzana = Wynik.Odleglosci.get(i);
                                sprawdz_id = i;
                            }
                        }
                    }
                    for (int i = 0; i < EdgeList.size(); i++)
                    {
                        if(EdgeList.get(i).getK2().getId()-1 == sprawdz_id)
                        {
                            
                            
                            
                            
                           if(Wynik.Odleglosci.get(sprawdz_id) + EdgeList.get(i).getWaga() < Wynik.Odleglosci.get(EdgeList.get(i).getK1().getId()-1)) 
                           {
                               Wynik.Odleglosci.set(EdgeList.get(i).getK1().getId()-1, Wynik.Odleglosci.get(sprawdz_id) + EdgeList.get(i).getWaga());
                               Wynik.Poprzednik.set(EdgeList.get(i).getK1().getId()-1, sprawdz_id);
                           }
                        }
                    }
                    Wynik.checked.set(sprawdz_id, true);
                    
                }
        return Wynik;
    }
    
}

class DijkstraResult
{
  ArrayList <Integer> Odleglosci;
    ArrayList <Integer> Poprzednik;
     ArrayList<Boolean> checked;

    DijkstraResult(int size)
    {  Odleglosci = new ArrayList(size);
        Poprzednik = new ArrayList(size);
        checked = new ArrayList(size);
        
            for (int i = 0; i < size; i++)
        {
            Odleglosci.add(new Integer(65000));
            Poprzednik.add(new Integer(-1));
            checked.add(new Boolean(false));
        }
    }


}