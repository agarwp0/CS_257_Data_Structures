import java.awt.Color;
import java.awt.Graphics;

public class GFilledRect extends GObject {

  public GFilledRect (double x, double y, double w, double h, GWindow dc){
    moveTo(x,y);
    setSize(w,h);
    dc.add(this);
  }

  public void paint(Graphics g){
    g.setColor(color);
    g.fillRect( (int)x, (int)y, (int)width, (int)height );
  }

  public void setSize(double w, double h){
    this.width = w;
    this.height = h;
    repaint();
  }

  protected double width,height;
}
