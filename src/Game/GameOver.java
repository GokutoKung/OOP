package Game;

import Map.*;
import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel{
    private Map map;

    public GameOver(Map map) {
        this.map = map;
        this.setPreferredSize(new Dimension(map.screenWidth, map.screenHieght));
    }
    
    public void draw(Graphics2D g2d){
        Image img = new ImageIcon("pic/game/over.jpg").getImage();
        g2d.drawImage(img, 0, 0, this);
        
    }
}
