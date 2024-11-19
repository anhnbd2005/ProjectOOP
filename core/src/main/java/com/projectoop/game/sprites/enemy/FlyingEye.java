package com.projectoop.game.sprites.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.projectoop.game.screens.PlayScreen;

public class FlyingEye extends GroundEnemy{

    public FlyingEye(PlayScreen screen, float x, float y) {
        super(screen, x, y, 0.3f, 2);
    }

    @Override
    protected void prepareAnimation(){
        atlasWalking = new TextureAtlas("E_FlyingEye/Pack/Walk.pack");
        atlasAttacking = new TextureAtlas("E_FlyingEye/Pack/Attack.pack");
        atlasDieing = new TextureAtlas("E_FlyingEye/Pack/Death.pack");
        atlasHurting = new TextureAtlas("E_FlyingEye/Pack/Hurt.pack");

        walkAnimation = new Animation<TextureRegion>(0.3f, atlasWalking.getRegions());
        attackAnimation = new Animation<TextureRegion>(0.3f, atlasAttacking.getRegions());
        dieAnimation = new Animation<TextureRegion>(0.2f, atlasDieing.getRegions());
        hurtAnimation = new Animation<TextureRegion>(0.3f, atlasHurting.getRegions());
    }
}
