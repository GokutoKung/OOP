package Game;

import Map.*;
import java.awt.*;
import javax.swing.*;

public class GameStart extends JPanel{
    private GameController c;
    private Map map;

    public GameStart(Map map, GameController c) {
        this.map = map;
        this.c = c;
        this.setPreferredSize(new Dimension(map.screenWidth, map.screenHieght));
        this.addMouseListener(c);
    }
    
    public void draw(Graphics2D g2d){
        Image img = new ImageIcon("pic/game/start.jpg").getImage();
        g2d.drawImage(img, 0, 0, this);
    }
}
