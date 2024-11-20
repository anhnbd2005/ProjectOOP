package com.projectoop.game.sprites.enemy;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.projectoop.game.screens.PlayScreen;

import java.util.ArrayList;

public class BossManager {
    private Array<GroundEnemy> groundEnemies;

    public World world;
    private PlayScreen screen;

    public BossManager(PlayScreen screen) {
        this.world = screen.getWorld();
        this.screen = screen;

        groundEnemies = new Array<>();
    }

    public void addEnemy(float x, float y, String name){
        GroundEnemy groundEnemy;
        switch (name){
            case "Goblin":
                groundEnemy = new Goblin(screen, x, y);
                break;
            case "Orc":
                groundEnemy = new Orc(screen, x, y);
                break;
            case "Skeleton":
                groundEnemy = new Skeleton(screen, x, y);
                break;
            default:
                groundEnemy = null;
                break;
        }
        if (groundEnemy != null) groundEnemies.add(groundEnemy);
    }

    public void update(float dt){
        Array<GroundEnemy> removeGroundEnemies = new Array<>();
        for (GroundEnemy groundEnemy : groundEnemies){
            groundEnemy.update(dt);
            if (groundEnemy.setToDestroy){//mark for removal
                removeGroundEnemies.add(groundEnemy);
            }
        }
        //debug();
       groundEnemies.removeAll(removeGroundEnemies, true); //remove all marked bullet
    }

    public void draw(Batch batch){
        for (GroundEnemy groundEnemy : groundEnemies){
            groundEnemy.draw(batch);
        }
    }

//    public void debug(){
//        System.out.println(bullets.size);
//        for (Bullet bullet : bullets){
//            System.out.println("posX: " + bullet.getX() + " speed: " + bullet.velocity.x);
//        }
//    }

    public void dispose() {
        for (GroundEnemy groundEnemy : groundEnemies){
            groundEnemy.dispose();
        }
        groundEnemies.clear();
    }
}
