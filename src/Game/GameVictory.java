package Game;

import Map.*;
import java.awt.*;
import javax.swing.*;

public class GameVictory extends JPanel{
    private Map map;

    public GameVictory(Map map) {
        this.map = map;
        this.setPreferredSize(new Dimension(map.screenWidth, map.screenHieght));
    }
    
    public void draw(Graphics2D g2d){
        Image img = new ImageIcon("pic/game/victory.jpg").getImage();
        g2d.drawImage(img, 0, 0, this);
    }
}
