package Map;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class TileManager {
    private Map map;
    public Tile tile[];
    public int mapScreen[][];
    private String path[] = new String[6]; 

    public TileManager(Map map) {
        this.map = map;
        tile = new Tile[11];
        mapScreen = new int[map.screenCol][map.screenRow];
        getTileImage();
        path[0] = "map/scene1.txt";
        path[1] = "map/scene2.txt";
        path[2] = "map/scene3.txt";
        path[3] = "map/scene4.txt";
        path[4] = "map/scene5.txt";
        path[5] = "map/scene6.txt";
        loadMap();
    }
    
    public void changeTile(){
        loadMap();
    }
    
    public void loadMap(){
        try(FileReader fr = new FileReader(path[map.scene.getScene()-1]);BufferedReader br = new BufferedReader(fr);){
            int col = 0;
            int row = 0;
            while(col < map.screenCol && row < map.screenRow){
                String line = br.readLine();
                
                while(col < map.screenCol){
                    String number[] = line.split(" ");
                    
                    int num = Integer.parseInt(number[col]);
                    
                    mapScreen[col][row] = num;
                    col++;
                }
                if(col == map.screenCol){
                    col = 0;
                    row++;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getTileImage(){
        tile[0] = new Tile();
        tile[0].img = new ImageIcon("pic/tile/tile.png").getImage();
        
        tile[1] = new Tile();
        tile[1].img = new ImageIcon("pic/tile/tile.png").getImage();
        tile[1].collision = true;
        
        tile[2] = new Tile();
        tile[2].img = new ImageIcon("pic/npc/npc1.png").getImage();
        tile[2].collision = true;
        tile[2].npc = true;
        
        tile[3] = new Tile();
        tile[3].img = new ImageIcon("pic/npc/npc2.png").getImage();
        tile[3].collision = true;
        tile[3].npc = true;
        
        tile[4] = new Tile();
        tile[4].img = new ImageIcon("pic/npc/npc3.png").getImage();
        tile[4].collision = true;
        tile[4].npc = true;
        
        tile[5] = new Tile();
        tile[5].img = new ImageIcon("pic/npc/npc4.png").getImage();
        tile[5].collision = true;
        tile[5].npc = true;
        
        tile[6] = new Tile();
        tile[6].img = new ImageIcon("pic/npc/npc5.png").getImage();
        tile[6].collision = true;
        tile[6].npc = true;
        
        tile[7] = new Tile();
        tile[7].img = new ImageIcon("pic/npc/npc6.png").getImage();
        tile[7].collision = true;
        tile[7].npc = true;
        
        tile[8] = new Tile();
        tile[8].img = new ImageIcon("pic/tile/tile.png").getImage();
        tile[8].collision = true;
        tile[8].monster = true;
        
        tile[9] = new Tile();
        tile[9].img = new ImageIcon("pic/tile/tile.png").getImage();
        tile[9].collision = true;
        tile[9].shop = true;
        
        tile[10] = new Tile();
        tile[10].img = new ImageIcon("pic/other/potion.png").getImage();
        tile[10].collision = true;
    }
    
    public void draw(Graphics2D g2d){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while(col < map.screenCol && row < map.screenRow){
            int tileNum = mapScreen[col][row];
            
            g2d.drawImage(tile[tileNum].img, x, y, map.tileSize, map.tileSize, map);
            
            col++;
            x += map.tileSize;
            
            if(col == map.screenCol){
                col = 0;
                row++;
                x = 0;
                y += map.tileSize;
            }
        }
    }
}
