package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class MapAnalyzer {
  public static TiledMap tmap;
  public int mapWidth;
  public int mapHeight;
  public ArrayList<Object> festeMauer;
  public ArrayList<Object> zerstMauer;
  
  /*
   * tiled-Map wird analysiert. Entsprechend der jeweiligen ID, wird ein Polygon gesetzt.
   */
  
  public MapAnalyzer(String ref) throws SlickException {
    
    festeMauer = new ArrayList<Object>();
    zerstMauer = new ArrayList<Object>();
    tmap = new TiledMap(ref, "res");
    mapWidth = tmap.getWidth() * tmap.getTileWidth();
    mapHeight = tmap.getHeight() * tmap.getTileHeight();
    
    for (int x = 0; x < tmap.getWidth(); x++) {
      for (int y = 0; y < tmap.getHeight(); y++) {
        final int tileID = tmap.getTileId(x, y, 0);
        if (tileID == 17) {
          festeMauer.add(new Block(x * 32, y * 32));
         }
       }
     }
    for (int x = 0; x < tmap.getWidth(); x++) {
      for (int y = 0; y < tmap.getHeight(); y++) {
        final int tileID = tmap.getTileId(x, y, 0);
        if (tileID == 2) {
          zerstMauer.add(new Block(x * 32, y * 32));
         }
       }
     }
    }
}
