/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafy;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class MyMouse implements MouseListener
{
    private final JPanel jPanel1;
    static Knot dragknot;
    int h;
    MyMouse(JPanel jPanel1, int h)
    {
        this.jPanel1= jPanel1;
        this.h = h;
    }

    public void setH(int h)
    {
        this.h = h;
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
      
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(""+ me.getPoint());
        
     
        for (Knot k:MyPanel.KnotList)
        {
            
            System.out.println(h);
            Rectangle re = new Rectangle(k.getX()-(h/2), k.getY()-(h/2), h, h);
            
            if(re.contains(me.getPoint()))
            {
                System.out.println(k);
                dragknot = k;
                break;
            }
        }
       
        
        
        
        
      
             
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        if(dragknot!=null)
        {
            
            dragknot.setX((int)me.getPoint().getX());
            dragknot.setY((int)me.getPoint().getY());
            jPanel1.repaint();
            
            dragknot=null;
        }
        
        
        
        
        
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
