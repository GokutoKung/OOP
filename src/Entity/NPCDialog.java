package Entity;

import Game.*;
import Map.*;
import java.awt.*;
import javax.swing.*;

public class NPCDialog {
    private Map map;
    private GameController c;
    private String msg[];

    public NPCDialog(Map map, GameController c) {
        this.map = map;
        this.c = c;
        msg = new String[6];
        setDialog();
    }
    
    public void setDialog(){
        msg[0] = "Please go and help this village...[Bank]...\n"
                + "We are in trouble. because that Monster...";
        msg[1] = "You finally arrived [Bank] ,I will teach you about how to fight.\n" 
                + "Press Z for attack on those Monsters if it dies, \n"
                + "you get money and ATK increases.\n"
                + "that all done. hope you can manage your money \n"
                + "and life force well and go get rid of that Monsters.";
        msg[2] = "Please be careful. It's getting more dangerous around here, \n"
                + "this is where the Monsters are...";
        msg[3] = "Be careful...this demon is higher level than the others.";
        msg[4] = "Welcome, Customers. Are you hurt ? \n"
                + "Come and buy a potion with us...we have some good stuff~ \n"
                + "Press V for buy Potions";
        msg[5] = "In front of you...Be the Boss's place that Evil destroyed \n"
                + "everything and left nothing.\n" 
                + "Please, Lord Bank...be careful because it's very Dangerous...\n"
                + "if you miss it, we would...";
    }
    
    public void draw(Graphics2D g2d){
        if(c.openDialog == true && map.p.npcOn == true){
            drawDialog(g2d);
        }
    }
    
    public void drawDialog(Graphics2D g2d){
        int x = map.tileSize*2;
        int y = map.tileSize/2;
        int width = map.screenWidth - (map.tileSize*4);
        int height = map.tileSize*5;
        
        drawSubWindow(x, y, width, height, g2d);
        
    }
    
    public void drawSubWindow(int x, int y, int width, int height, Graphics2D g2d){
        Color c = new Color(0, 0, 0);
        g2d.setColor(c);
        g2d.fillRoundRect(x, y, width, height, 35, 35);
        c = new Color(255, 255, 255);
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        g2d.setFont(new Font ( "TimesRoman", Font.BOLD, 24 ));
        for (String line : msg[map.scene.getScene()-1].split("\n")){
            g2d.drawString(line, x+map.tileSize, y+map.tileSize);
            y+=40;
        }
    }
}
