package Entity;

import Game.*;
import Map.*;
import java.awt.*;
import javax.swing.*;

public class Player extends Entity{
    private Map map;
    private GameController c;

    public Player(Map map, GameController c) {
        this.map = map;
        this.c = c;
        setLocation(480, 480, 5);
        getPlayerImage();
        
        solidArea = new Rectangle();
        solidArea.x = 5;
        solidArea.y = 5;
        solidArea.width = 45;
        solidArea.height = 45;
    }
    
    public void setLocation(int x, int y, int speed){
        super.worldX = x;
        super.worldY = y;
        direction = "down";
    }
    
    public void getPlayerImage(){
        try{
            up = new ImageIcon("pic/sprite/up2.png").getImage();
            up2 = new ImageIcon("pic/sprite/up3.png").getImage();
            down = new ImageIcon("pic/sprite/down2.png").getImage();
            down2 = new ImageIcon("pic/sprite/down3.png").getImage();
            left = new ImageIcon("pic/sprite/left2.png").getImage();
            left2 = new ImageIcon("pic/sprite/left3.png").getImage();
            right = new ImageIcon("pic/sprite/right2.png").getImage();
            right2 = new ImageIcon("pic/sprite/right3.png").getImage();  
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        if(c.upPressed == true || c.downPressed == true || c.leftPressed == true || c.rightPressed == true){
            if(c.upPressed == true){
                direction = "up";
            }
            else if(c.downPressed == true){
                direction = "down";
            }
            else if(c.leftPressed == true){
                direction = "left";
            }
            else if(c.rightPressed == true){
                direction = "right";
            }
            map.tm.changeTile();
            map.scene.update(worldX, worldY);
        
            collisionOn = false;
            npcOn = false;
            monsterOn = false;
            shopOn = false;
            
            map.collision.checkTile(this);
  
            if(collisionOn == false){
                if(c.upPressed == true){
                    direction = "up";
                    worldY -= speed;
                }
                else if(c.downPressed == true){
                    direction = "down";
                    worldY += speed;
                }
                else if(c.leftPressed == true){
                    direction = "left";
                    worldX -= speed;
                }
                else if(c.rightPressed == true){
                    direction = "right";
                    worldX += speed;
                }
            }
        
            SpriteCount++;
            if(SpriteCount > 12){
                if(SpriteNum == 1){
                    SpriteNum = 2;
                }
                else if(SpriteNum == 2){
                    SpriteNum = 1;
                }
                SpriteCount = 0;
            }
        }
    }
    
    public void drawStat(Graphics2D g2d){
        Image image = new ImageIcon("pic/other/heart.png").getImage();
        int x = 0;

        Color c = new Color(0, 0, 0);
        g2d.setColor(c);
        g2d.fillRect(0, 0, 200, 40);
        for(int i=0; i<super.hp; i++){
            g2d.drawImage(image, x, 5, 30, 30, null);
            x += 40;
        }
        g2d.fillRect(760, 0, 200, 40);
        image = new ImageIcon("pic/other/gold.png").getImage();
        g2d.drawImage(image, 760, 5, 30, 30, null);
        c = new Color(255, 255, 255);
        g2d.setColor(c);
        g2d.setFont(new Font ( "TimesRoman", Font.BOLD, 36 ));
        g2d.drawString(super.gold+"", 840, 35);
    }
    
    public void draw(Graphics2D g2d){
        Image image = null;
        switch(direction){
            case "up":
                if(SpriteNum == 1){
                    image = up;
                }
                if(SpriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(SpriteNum == 1){
                    image = down;
                }
                if(SpriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(SpriteNum == 1){
                    image = left;
                }
                if(SpriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(SpriteNum == 1){
                    image = right;
                }
                if(SpriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2d.drawImage(image, worldX, worldY, map.tileSize, map.tileSize, null);
    }
    
    
}
