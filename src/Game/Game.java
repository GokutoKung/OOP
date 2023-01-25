package Game;

import Map.Map;
import java.awt.*;
import javax.swing.*;

public class Game{
    private JFrame fr;
    private Map map = new Map();

    public Game() {
        fr = new JFrame("Bank Advanture");
        
        fr.add (map);
        fr.setVisible(true);
        fr.pack();
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        map.startThread();
    }
}
