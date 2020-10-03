import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class WC implements MouseListener,MouseMotionListener {

              // ??? import java.awt.event.MouseInputAdapter;
              // ??? public class WC extends MouseInputAdapter {

  public void startController(int w, int h){
    canvas = new GWindow(w,h);
    canvas.addMouseListener(this);
    canvas.addMouseMotionListener(this);
    begin();
  }
  public int getWidth(){return canvas.getWidth();}
  public int getHeight(){return canvas.getHeight();}

  public void begin(){
  }

  //-----------------------------------------------------------------
  // versions required by WC (extending clients must have available!)
  //   different parameter -and- slightly name changes from below...
  //-----------------------------------------------------------------
  public void onMouseClick(Location p){}
  public void onMouseEnter(Location p){}
  public void onMouseExit(Location p){}
  public void onMousePress(Location p){}
  public void onMouseRelease(Location p){}
  //-- required by INTERFACE; not used by objectdraw faking clients
  //...............................................................
  public void mouseClicked(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mousePressed(MouseEvent e){
    // LKD - compensating for toolbar?!?
    //       actually works BETTER than objectdraw getHeight()
    //       BUT is "22" particular to my macbook screen size/resolution?!?
    onMousePress( new Location(e.getX(), e.getY()-22) );  
  }
  public void mouseReleased(MouseEvent e){}


  //-----------------------------------------------------------------
  // versions required by WC (extending clients must have available!)
  //   different parameter -and- slightly name changes from below...
  //-----------------------------------------------------------------
  public void onMouseMove(Location p){}
  public void onMouseDrag(Location p){}
  //-- required by INTERFACE; not used by objectdraw faking cients
  //..............................................................
  public void mouseMoved(MouseEvent e){}
  public void mouseDragged(MouseEvent e){
    onMouseDrag( new Location(e.getX(), e.getY()-22) );  
  }
  
  protected GWindow canvas;

}
