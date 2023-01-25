package Map;

public class Scene {
    private int scene = 1;
    private Map map;

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public Scene(Map map) {
        this.map = map;
    }
    
    public void update(int x, int y){
        if(scene == 1){
            if(y <= 10){
                map.p.screenX = 0;
                map.p.screenY = 0;
                map.p.setLocation(480, 850, 5);
                scene = 2;
            }
        }
        else if(scene == 2){
            if(x >= 860){
                map.p.screenX = -961;
                map.p.screenY = 0;
                map.p.setLocation(15, 480, 5);
                scene = 3;
            }
            else if(y >= 860){
                map.p.screenX = 0;
                map.p.screenY = -961;
                map.p.setLocation(480, 15, 5);
                scene = 1;
            }
        }
        else if(scene == 3){
            if(x <= 10){
                map.p.screenX = 0;
                map.p.screenY = 0;
                map.p.setLocation(840, 480, 5);
                scene = 2;
            }
            else if(y >= 860){
                map.p.screenX = -961;
                map.p.screenY = -961;
                map.p.setLocation(480, 15, 5);
                scene = 4;
            }
            else if(x >= 860){
                map.p.screenX = -1921;
                map.p.screenY = 0;
                map.p.setLocation(20, 336, 5);
                scene = 5;
            }
        }
        else if(scene == 4){
            if(y <= 10){
                map.p.screenX = -961;
                map.p.screenY = 0;
                map.p.setLocation(336, 850, 5);
                scene = 3;
            }
            else if(x >= 864){
                map.p.screenX = -1921;
                map.p.screenY = -961;
                map.p.setLocation(96, 96, 5);
                scene = 6;
            }
        }
        else if(scene == 5){
            if(x <= 10){
                map.p.screenX = -961;
                map.p.screenY = 0;
                map.p.setLocation(850, 336, 5);
                scene = 3;
            }
        }
        else if(scene == 6){
            if(x <= 10){
                map.p.screenX = -961;
                map.p.screenY = -961;
                map.p.setLocation(864, 96, 5);
                scene = 4;
            }
        }
    }
}
