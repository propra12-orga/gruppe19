package de.game.bomberman;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class BlockMap {
  public static TiledMap tmap;
  public int mapWidth;
  public int mapHeight;
  private int square[] = { 0, 0, 31, 0, 31, 31, 0, 31 }; // square shaped
  // tile, Eckpunkte
  // der Mauer
  public ArrayList<Object> entities; // Array für die Mauerstücke
  
  /*
   * Nachfolgend wird die TiledMap analysiert. Unsere Map besteht zur Zeit aus
   * zwei versch. Sprites, die jeweils Boden oder Mauer darstellen. Die tileID
   * des Bodens ist 1, die der Mauer 17. Es wird bei jeder Map-Koordinate
   * überprüft, ob sie der Mauer-ID entspricht. Wenn ja, wird sie als
   * undurchlässig markiert.
   */
  
  public BlockMap(String ref) throws SlickException {
    
    entities = new ArrayList<Object>();
    tmap = new TiledMap(ref, "res");
    mapWidth = tmap.getWidth() * tmap.getTileWidth();
    mapHeight = tmap.getHeight() * tmap.getTileHeight();
    
    for (int x = 0; x < tmap.getWidth(); x++) {
      for (int y = 0; y < tmap.getHeight(); y++) {
        final int tileID = tmap.getTileId(x, y, 0);
        if (tileID == 17) {
          entities.add(
          // Nun wird die Mauer gemacht, in der Block-Klasse is
          // geschrieben, wie es genau klappt
              new Block(x * 32, y * 32, square));
        }
      }
    }
  }
}