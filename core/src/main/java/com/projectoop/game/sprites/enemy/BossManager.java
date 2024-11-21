package com.projectoop.game.sprites.enemy;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.projectoop.game.GameWorld;
import com.projectoop.game.screens.PlayScreen;
import com.projectoop.game.sprites.Knight;

import java.util.ArrayList;
import java.util.Vector;

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
                groundEnemy = new FlyEnemy(screen, x, y);
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
        if (groundEnemy != null&&groundEnemies.size<=1){
            groundEnemy.setVelocity(new Vector2(-1, 0));
            groundEnemies.add(groundEnemy);
        }
    }

    public void update(float dt){
        Array<GroundEnemy> removeGroundEnemies = new Array<>();
        for (GroundEnemy groundEnemy : groundEnemies){
            groundEnemy.update(dt);
            groundEnemy.b2body.setActive(true);
       //     if (groundEnemy.getX() < screen.getPlayer().getX() + (GameWorld.V_WIDTH/2 + 4 * 16)/GameWorld.PPM){
//            groundEnemy.b2body.setActive(true);
        //}
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
    public Array<GroundEnemy> getGroundEnemies(){
        return groundEnemies;
    }}
