package Map;

import Entity.*;
import Game.*;
import Sound.*;
import java.awt.*;
import javax.swing.*;

public class Map extends JPanel implements Runnable{
    public final int tileSize = 48;
    
    public final int screenCol = 20;
    public final int screenRow = 20;
    public final int screenWidth = tileSize * screenCol;
    public final int screenHieght = tileSize * screenRow;
    
    private Thread thread;
    private GameController c = new GameController(this);
    public Scene scene = new Scene(this);
    public TileManager tm = new TileManager(this);
    public Collision collision = new Collision(this);
    public Sound sound = new Sound();
    public Player p = new Player(this, c);
    private NPCDialog npc = new NPCDialog(this, c);
    public MonsterBattle mbattle = new MonsterBattle(this, c);
    public ShopKeeper sk = new ShopKeeper(this);
    private GameStart gs = new GameStart(this, c);
    private GameOver go = new GameOver(this);
    private GameVictory gv = new GameVictory(this);

    public Graphics2D g2d;

    public Map() {
        this.setPreferredSize(new Dimension(screenWidth, screenHieght));
        this.setDoubleBuffered(true);
        this.addKeyListener(c);
        this.addMouseListener(c);
        this.setFocusable(true);
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }
    
    public void update(){
        p.update();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g2d = (Graphics2D) g;

        if(c.gameState == 0){
            gs.draw(g2d);
        }
        else if(c.gameState == 1){
            Image img = new ImageIcon("pic/map/background.png").getImage();
            g2d.drawImage(img, p.screenX, p.screenY, this);
            
            tm.draw(g2d);
            p.draw(g2d);
            mbattle.draw(g2d);
            p.drawStat(g2d);
            npc.draw(g2d);
            
            g2d.dispose();
        }
        else if(c.gameState == 2){
            go.draw(g2d);
        }
        else if(c.gameState == 3){
            gv.draw(g2d);
        }
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(thread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
}
