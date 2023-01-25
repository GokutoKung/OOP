package Game;

import Map.Map;
import java.awt.event.*;

public class GameController implements KeyListener, MouseListener{
    public boolean upPressed, downPressed, leftPressed, rightPressed, openDialog;
    public int gameState = 0;
    
    private Map map;
    
    public GameController(Map map) {
        this.map = map;
    }

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        
        if(code == KeyEvent.VK_UP){
            upPressed = true;
        }
        else if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        else if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        else if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        else if(code == KeyEvent.VK_SPACE){
            openDialog = true;
        }
        else if(code == KeyEvent.VK_Z){
            map.mbattle.checkFight(map.scene.getScene());    
        }
        else if(code == KeyEvent.VK_V){
            map.sk.buyPosion();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int code = ke.getKeyCode();
        
        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }
        else if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        else if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        else if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        else if(code == KeyEvent.VK_SPACE){
            openDialog = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {
        if(gameState == 0){
            gameState = 1;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
}
