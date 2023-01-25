package Entity;

import Map.*;

public class ShopKeeper {
    private Map map;

    public ShopKeeper(Map map) {
        this.map = map;
    }
    
    public void buyPosion(){
        if(map.p.shopOn == true){
            if(map.p.gold >= 250 && map.p.hp < 5){
                map.sound.heal();
                map.p.gold -= 250;
                map.p.hp += 1;
            }
        }
    }
}
