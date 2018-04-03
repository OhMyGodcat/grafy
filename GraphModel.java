/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafy;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class GraphModel extends AbstractTableModel
{
JPanel jPanel1;
    GraphModel(JPanel jPanel1)
    {
      this.jPanel1= jPanel1;
    }

  

    @Override
    public int getRowCount()
    {
      return MyPanel.KnotList.size();
    }

    @Override
    public int getColumnCount()
    {
        return MyPanel.KnotList.size()+1;
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        if(col==0)
        {
            return row+1;
        }
        else
        {
            Knot k1 = MyPanel.KnotList.get(col-1);
            Knot k2 = MyPanel.KnotList.get(row);
            for (Edge e:MyPanel.EdgeList)
            {
                if((e.getK1() == k2 && e.getK2() == k1))
                {
                    return e.getWaga();
                }
                
            }
            
            
            
            
            
            return 0;
        }
    }

    @Override
    public String getColumnName(int i)
    {
        if(i==0)
        {
            return "\\";
        }
        else
        {
            return ""+(i);
        }
    }

    @Override
    public void setValueAt(Object o, int row, int col)
    { 
      Knot k1 = MyPanel.KnotList.get(col-1);
      Knot k2 = MyPanel.KnotList.get(row);
      Integer vaal  = Integer.parseInt((String) o);
      if (vaal == 0)
      {
          for (Edge e:MyPanel.EdgeList)// Naszym zadaniem jest znikanie krawędzi gdy vaal = 0 ORAZ gdy krawędź istnieje i pojawianianie jej gdy vaal !=0 ORAZ gdy krawędź nie istnieje
          {
          if((e.getK1() == k1 && e.getK2() == k2) || (e.getK1() == k2 && e.getK2() == k1))
          {
              MyPanel.EdgeList.remove(e);
              break;
          }
          
      
          }
      }
      else
      {
      boolean CzyZbreakowal = false;
            for (Edge e:MyPanel.EdgeList)
            {
                if((e.getK1() == k1 && e.getK2() == k2) || (e.getK1() == k2 && e.getK2() == k1))
                {
                    e.setWaga(vaal);
                    CzyZbreakowal = true;
                    break;
                }
                
            }
            if(!CzyZbreakowal)
            {
                Edge a = new Edge ((MyPanel.EdgeList.get(MyPanel.EdgeList.size()-1).getId())+1, 0, vaal, k1, k2);
                MyPanel.EdgeList.add(a);
            }
      }
      
      jPanel1.repaint();
        
        
        
        
    }

    @Override
    public boolean isCellEditable(int row, int col)
    {
        if(col==0)
        {
            return (false);
        }
        else
        {
            return (true);
        }
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
