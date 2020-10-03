/* Pravesh Agarwal
 * hw2, * Feb 17, 2020
 * Class borrowed from book
 */

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class GCanvas extends JComponent{
  
    // list of objects placed on this canvas
  private ArrayList<GObject> contents;

  public GCanvas (){
    contents=new ArrayList<GObject>();
  }

  public GCanvas (int w, int h){
    this();
    setSize( w, h);  // method in JComponent
    
    //both method in component, getSize returns dimention type
    //setPreferredSize takes Dimension type as parameter
    setPreferredSize( getSize() );  
  }

    // adds graphical object to this canvas
  public void add(GObject gob){
    // synchronized gives exclusive access when multiple threads are running 
    synchronized(contents) { 
      contents.add(gob);
      gob.gc = this; // ?
    }
    repaint();
  }

    // paints all the objects currently on this canvas 
  public void paintComponent(Graphics g){
    synchronized(contents) {
      for(GObject obj: contents)
        obj.paint(g);
    }
  }
 
}
