package Map;

import Entity.*;

public class Collision {
    Map map;

    public Collision(Map map) {
        this.map = map;
    }
    
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entityLeftWorldX + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entityTopWorldY + entity.solidArea.height;
        
        int entityLeftCol = entityLeftWorldX/map.tileSize;
        int entityRightCol = entityRightWorldX/map.tileSize;
        int entityTopRow = entityTopWorldY/map.tileSize;
        int entityBottomRow = entityBottomWorldY/map.tileSize;
        
        int tile;
        
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/map.tileSize;
                tile = map.tm.mapScreen[entityLeftCol][entityTopRow];
                if(map.tm.tile[tile].npc == true){
                    entity.collisionOn = true;
                    entity.npcOn = true;
                }
                else if(map.tm.tile[tile].monster == true){
                    entity.collisionOn = true;
                    entity.monsterOn = true;
                }
                else if(map.tm.tile[tile].shop == true){
                    entity.collisionOn = true;
                    entity.shopOn = true;
                }
                else if(map.tm.tile[tile].collision == true){
                    entity.collisionOn = true;
                }
                
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/map.tileSize;
                tile = map.tm.mapScreen[entityLeftCol][entityBottomRow];
                if( map.tm.tile[tile].npc == true){
                    entity.collisionOn = true;
                    entity.npcOn = true;
                }
                else if(map.tm.tile[tile].monster == true){
                    entity.collisionOn = true;
                    entity.monsterOn = true;
                }
                else if(map.tm.tile[tile].shop == true){
                    entity.collisionOn = true;
                    entity.shopOn = true;
                }
                 else if(map.tm.tile[tile].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/map.tileSize;
                tile = map.tm.mapScreen[entityLeftCol][entityTopRow];
                if(map.tm.tile[tile].npc == true){
                    entity.collisionOn = true;
                    entity.npcOn = true;
                }
                else if(map.tm.tile[tile].monster == true){
                    entity.collisionOn = true;
                    entity.monsterOn = true;
                }
                else if(map.tm.tile[tile].shop == true){
                    entity.collisionOn = true;
                    entity.shopOn = true;
                }
                 else if(map.tm.tile[tile].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/map.tileSize;
                tile = map.tm.mapScreen[entityRightCol][entityTopRow];
                if(map.tm.tile[tile].npc == true){
                    entity.collisionOn = true;
                    entity.npcOn = true;
                }
                else if(map.tm.tile[tile].monster == true){
                    entity.collisionOn = true;
                    entity.monsterOn = true;
                }
                else if(map.tm.tile[tile].shop == true){
                    entity.collisionOn = true;
                    entity.shopOn = true;
                }
                 else if(map.tm.tile[tile].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
