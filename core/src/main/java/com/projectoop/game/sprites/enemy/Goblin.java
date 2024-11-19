package com.projectoop.game.sprites.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.projectoop.game.GameWorld;
import com.projectoop.game.screens.PlayScreen;

public class Goblin extends GroundEnemy{
    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    public Goblin(PlayScreen screen, float x, float y) {
        super(screen, x, y, 50, 1.2f);
    }

    @Override
    protected void prepareAnimation() {
        atlasWalking = new TextureAtlas("Bringer-Of-Death/Pack/Walk.pack");
        atlasAttacking = new TextureAtlas("Bringer-Of-Death/Pack/Attack.pack");
        atlasDieing = new TextureAtlas("Bringer-Of-Death/Pack/Death.pack");
        atlasHurting = new TextureAtlas("Bringer-Of-Death/Pack/Hurt.pack");

        walkAnimation = new Animation<TextureRegion>(0.3f, atlasWalking.getRegions());
        attackAnimation = new Animation<TextureRegion>(0.2f, atlasAttacking.getRegions());
        dieAnimation = new Animation<TextureRegion>(0.2f, atlasDieing.getRegions());
        hurtAnimation = new Animation<TextureRegion>(0.3f, atlasHurting.getRegions());
    }

    @Override
    public void update(float dt) {
        stateTime += dt;
        if (setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
            stateTime = 0;
        }
        else if (!destroyed){
            TextureRegion frame = getFrame(dt);
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth()/2-50/GameWorld.PPM, b2body.getPosition().y - getHeight()/2);
            //this y + addY to move the animation stand on the ground
            setBounds(getX(), getY()+ addYtoAnim/ GameWorld.PPM, frame.getRegionWidth() / GameWorld.PPM * scaleX,
                frame.getRegionHeight() / GameWorld.PPM * scaleY);
            setRegion(frame);
        }
    }
}
