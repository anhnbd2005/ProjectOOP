package com.projectoop.game.sprites.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.projectoop.game.screens.PlayScreen;

public class Goblin extends GroundEnemy{

    public Goblin(PlayScreen screen, float x, float y) {
        super(screen, x, y, 50, 1.2f);
    }

    @Override
    protected void prepareAnimation() {
        atlasWalking = new TextureAtlas("E_Goblin/Pack/Walk.pack");
        atlasAttacking = new TextureAtlas("E_Goblin/Pack/Attack.pack");
        atlasDieing = new TextureAtlas("E_Goblin/Pack/Death.pack");
        atlasHurting = new TextureAtlas("E_Goblin/Pack/Hurt.pack");

        walkAnimation = new Animation<TextureRegion>(0.3f, atlasWalking.getRegions());
        attackAnimation = new Animation<TextureRegion>(0.2f, atlasAttacking.getRegions());
        dieAnimation = new Animation<TextureRegion>(0.2f, atlasDieing.getRegions());
        hurtAnimation = new Animation<TextureRegion>(0.3f, atlasHurting.getRegions());
    }
}