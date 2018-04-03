/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class MyPanel extends JPanel
{

    static ArrayList<Edge> EdgeList;
    static ArrayList<Knot> KnotList;
    static int h;

    public void rysujgraf(Graphics g, Knot k1, Knot k2, int waga)
    {
         Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Color.BLACK);
        
        Edge e= MainFrame.KnotsToEdge(k1, k2);
        BasicStroke bs = new BasicStroke(e.getSzerokosc(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, null, 10);
    g2d.setStroke(bs);  
        g2d.drawLine(k1.getX(), k1.getY(), k2.getX(), k2.getY());
        g.setColor(k1.getKolor());
        g.fillOval(k1.getX() - (h / 2), k1.getY() - (h / 2), h, h);
        g.setColor(Color.BLACK);
        
        
          FontMetrics fm = g.getFontMetrics();
            int strWidth = fm.stringWidth(""+k1.getId());
            int strHeight = fm.getHeight();
        
        g.drawString(""+k1.getId(), k1.getX()-(strWidth/2), k1.getY()+(strHeight/2));
        g.setColor(k2.getKolor());
        g.fillOval(k2.getX() - (h / 2), k2.getY() - (h / 2), h, h);
        g.setColor(Color.BLACK);
        strWidth = fm.stringWidth(""+k2.getId());
        strHeight = fm.getHeight();
        g.drawString(""+k2.getId(), k2.getX()-(strWidth/2), k2.getY()+(strHeight/2));
        g.setColor(Color.RED);
        g.drawString(""+waga, ((k2.getX())*3+k1.getX())/4, ((k2.getY())*3+k1.getY())/4);
        g.setColor(Color.BLACK);

        ArrayList<MyPoint> arr = PoliczPunkt(k1, k2, h / 2, 8, 10);
        //g.drawLine(k1.getX(), k1.getY(), (int)arr.get(0).getX(), (int)arr.get(0).getY());
        //g.drawLine(k1.getX(), k1.getY(), (int)arr.get(1).getX(), (int)arr.get(1).getY());
        Polygon poly = new Polygon();
        poly.addPoint((int) arr.get(2).getX(), (int) arr.get(2).getY());
        poly.addPoint((int) arr.get(0).getX(), (int) arr.get(0).getY());
        poly.addPoint((int) arr.get(1).getX(), (int) arr.get(1).getY());
        poly.addPoint((int) arr.get(2).getX(), (int) arr.get(2).getY());
        g.fillPolygon(poly);

    }

    public static void graf(int n, int width, int height, int h1)
    {
        h = h1;
        int limit = (int) Math.ceil( (n*(n-1)) / 2.5);  // Ile musi być krawędzi
        int pomocnicza = limit;
        int losowanie;
        EdgeList = new ArrayList();
        KnotList = new ArrayList();
        int b = 1;
        for (int i = 0; i < n; i++)
        {
            Knot k1;
            Color c;
            c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

            boolean p = true;
            int x = (int) (Math.random() * (width - h) + (h / 2));
            int y = (int) (Math.random() * (height - (h)) + (h / 2));
            /*  for (int j = 0; j < 1000; j++)
             {
             for (Knot k : KnotList)
             {
             if()
                    
             }
             }*/

            k1 = new Knot(i + 1, c, x, y);
            KnotList.add(k1);
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                
                if (i != j)
                {
                    losowanie = (int) (Math.random() * 2);
                    if (pomocnicza == n)
                    {
                        losowanie = 1;
                    }
                    if (losowanie == 1)
                    {
                        Edge a1 = new Edge(b, 0, (int) (Math.random() * 25 + 1), KnotList.get(i), KnotList.get(j));
                        EdgeList.add(a1);
                        --limit;
                    } 
                    else
                    {
                        ++pomocnicza;
                    }
                    
                }
                if (limit == 0)
                {
                    break;
                }
            }
            if (limit == 0)
                    {
                        break;
                    }

        }
    }
    
    
    void ZnajdzSciezke (int start, int koniec)
    {
        
        
       
    }
    
    
    
    
    
    

    
    

    @Override
    public void paint(Graphics g)
    {

        super.paint(g); //To change body of generated methods, choose Tools | Templates.+ 
        if (EdgeList != null)
        {
            for (int i = 0; i < EdgeList.size(); i++)
            {
                if (EdgeList.get(i).getWaga() != 0)
                {
                    rysujgraf(g, EdgeList.get(i).getK1(), EdgeList.get(i).getK2(), EdgeList.get(i).getWaga());
                }
            }
        }

    }

    double Odleglosc(double x, double y, Knot k)
    {
        double x1 = k.getX();
        double y1 = k.getY();
        double wynik = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
        return wynik;

    }

    MyPoint KtoryBlizej(double x1, double x2, double y1, double y2, Knot k)
    {
        double odl_1 = Odleglosc(x1, y1, k);
        double odl_2 = Odleglosc(x2, y2, k);

        if (odl_1 < odl_2)
        {
            return new MyPoint(x1, y1);
        } else
        {
            return new MyPoint(x2, y2);
        }
    }

    MyPoint p3(Knot k1, Knot k2, int r1)
    {
        double a1 = (double) (k2.getY() - (k1.getY())) / (k2.getX() - k1.getX());
        double b1 = k1.getY() - k1.getX() * a1;
        double A = 1 + a1 * a1;
        double B = 2 * a1 * b1 - 2 * k1.getX() - 2 * a1 * k1.getY();
        double C = k1.getX() * k1.getX() + b1 * b1 - 2 * k1.getY() * b1 + k1.getY() * k1.getY() - r1 * r1;
        double delta = Math.sqrt(B * B - 4 * A * C);
        double x1 = ((B * (-1)) - delta) / (2 * A);
        double x2 = ((B * (-1)) + delta) / (2 * A);
        double y1 = a1 * x1 + b1;
        double y2 = a1 * x2 + b1;
        MyPoint punkt = KtoryBlizej(x1, x2, y1, y2, k2);
        return punkt;

    }

    ArrayList<MyPoint> PoliczPunkt(Knot k1, Knot k2, int r1, int r2, int r3)

    {
        ArrayList<MyPoint> arr = new ArrayList();
        double a1 = (double) (k2.getY() - (k1.getY())) / (k2.getX() - k1.getX());
        MyPoint p3 = p3(k1, k2, r1);
        Knot k3 = new Knot(0, Color.yellow, (int) p3.getX(), (int) p3.getY());
        MyPoint punkt = p3(k3, k2, r3);
        double x3 = punkt.getX();
        double y3 = punkt.getY();
        double a2 = (1 / a1) * (-1);

        double b2 = y3 - a2 * x3;
        double A1 = 1 + a2 * a2;
        double B1 = 2 * a2 * b2 - 2 * x3 - 2 * a2 * y3;
        double C1 = x3 * x3 + b2 * b2 - 2 * y3 * b2 + y3 * y3 - r2 * r2;
        double delta1 = Math.sqrt(B1 * B1 - 4 * A1 * C1);
        double x4 = ((B1 * (-1)) - delta1) / (2 * A1);
        double x5 = ((B1 * (-1)) + delta1) / (2 * A1);
        double y4 = a2 * x4 + b2;
        double y5 = a2 * x5 + b2; // (x4,y4) oraz (x5,y5) są współrzędnymi wierzchołka strzałki
        MyPoint p1 = new MyPoint(x4, y4);
        MyPoint p2 = new MyPoint(x5, y5);
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        return arr;
    }

}
