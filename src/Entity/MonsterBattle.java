package Entity;

import Game.*;
import Map.*;
import java.awt.*;
import javax.swing.*;

public class MonsterBattle {
    private Map map;
    private GameController c;
    private Image img;
    
    Monster m1 = new Monster(3, 1, false);
    Monster m2 = new Monster(5, 1, false);
    Monster m3 = new Monster(7, 1, false);
    Monster m4 = new Monster(9, 1, false);

    public MonsterBattle(Map map, GameController c) {
        this.map = map;
        this.c = c;
    }
    
    public void checkDead(){
        if(m4.hp <= 0){
            c.gameState = 3;
        }
    }
    public void fight(Player p, Monster m){
        map.sound.attackMonster();
        m.hp -= p.atk;
        p.hp -= m.atk;
        checkDead(p, m);
        checkDead();
    }
    
    public void checkDead(Player p, Monster m){
        if(p.hp<=0){
            p.dead = true;
            c.gameState = 2;
        }
        if(m.hp <= 0){
            m.dead = true;
            p.gold += 1000;
            p.atk += m.atk;
        }

    }
    
    public void checkFight(int scene){
        if(map.p.monsterOn == true){
            if(map.scene.getScene() == 2 && m1.dead == false){
                fight(map.p, m1);
            }
            else if(map.scene.getScene() == 3 && m2.dead == false){
                fight(map.p, m2);
            }
            else if(map.scene.getScene() == 4 && m3.dead == false){
                fight(map.p, m3);
            }
            else if(map.scene.getScene() == 6 && m4.dead == false){
                fight(map.p, m4);
            }
        }
    }
    
    public void draw(Graphics2D g2d){
        img = null;
        if(map.scene.getScene() == 2 && m1.dead == false){
            img = new ImageIcon("pic/monster/monster1.png").getImage();
            g2d.drawImage(img, 144, 96, map);
        }
        else if(map.scene.getScene() == 3 && m2.dead == false){
            img = new ImageIcon("pic/monster/monster2.png").getImage();
            g2d.drawImage(img, 432, 0, map);
        }
        else if(map.scene.getScene() == 4 && m3.dead == false){
            img = new ImageIcon("pic/monster/monster3.png").getImage();
            g2d.drawImage(img,912, 672, map);
        }
        else if(map.scene.getScene() == 6 && m4.dead == false){
            if(m4.hp >= 5){
                img = new ImageIcon("pic/monster/monster4.png").getImage();
                g2d.drawImage(img, 96, 480, map);
            }
            else{
                img = new ImageIcon("pic/monster/monster5.png").getImage();
                m4.atk = 2;
                g2d.drawImage(img, 96, 480, map);
            }
        }
    }
}
