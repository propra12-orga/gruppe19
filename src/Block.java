import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

public class Block {
  public Polygon poly;
  
  /*
   * Der Mauer-Konstruktor "Block" nimmt die Koordinaten x, y, um zu wissen, wo
   * er die Mauer baut. Dann nimmt er die Eckpunkte unseres square-Arrays und
   * weiß, wie groß die Mauer sein soll.
   */
  
  public Block(int x, int y, int test[], String type) {
    poly = new Polygon(new float[] { x + test[0], y + test[1], x + test[2],
        y + test[3], x + test[4], y + test[5], x + test[6], y + test[7], });
  }
  
  public void draw(Graphics g) {
    g.draw(poly);
  }
  
  public void update(int delta) {
  }
}