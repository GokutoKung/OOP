package Entity;

import java.awt.*;

public class Entity {
    public int worldX, worldY;
    public int screenX = 0, screenY = -961;
    public final int speed = 5;
    public boolean dead = false;
    public int hp = 5;
    public int atk = 1;
    public int gold = 0;
    
    public Image up, down, left, right, up2, down2, left2, right2;
    public String direction;
    
    public int SpriteCount = 0;
    public int SpriteNum = 1;
    
    public Rectangle solidArea;
    
    public boolean collisionOn = false;
    public boolean npcOn = false;
    public boolean monsterOn = false;
    public boolean shopOn = false;
}
