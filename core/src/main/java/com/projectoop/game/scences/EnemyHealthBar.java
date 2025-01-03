package com.projectoop.game.scences;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.projectoop.game.GameWorld;
import com.projectoop.game.sprites.enemy.FlyEnemy;
import com.projectoop.game.sprites.enemy.Goblin;
import com.projectoop.game.sprites.enemy.GroundEnemy;
import com.projectoop.game.sprites.enemy.Orc;

public class EnemyHealthBar {
    private Texture bgTexture;
    private Texture redTexture;
    private float maxHealth;
    private float currentHealth;
    private GroundEnemy groundEnemy;

    public EnemyHealthBar(GroundEnemy groundEnemy, float maxHealth) {
        this.groundEnemy = groundEnemy;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        bgTexture = new Texture("HealthBar/bg.png");
        redTexture = new Texture("HealthBar/green.png");
    }

    public void update(float health) {
        this.currentHealth = health;
    }

    public void draw(Batch batch) {
        float healthPercentage = currentHealth / maxHealth;
        float barWidth = 50 / GameWorld.PPM;
        float barHeight = 8 / GameWorld.PPM;
       float barX = groundEnemy.getX() + groundEnemy.getWidth() / 2 / GameWorld.PPM + barWidth -5/ GameWorld.PPM;
        float barY = groundEnemy.getY() + groundEnemy.getHeight() / GameWorld.PPM + barHeight + 65 / GameWorld.PPM;
        if (groundEnemy instanceof FlyEnemy)
            barY += 13/GameWorld.PPM;
        else if(groundEnemy instanceof Orc)
        {
            barX+=25/GameWorld.PPM;
            barY += 50/GameWorld.PPM;

        }
        else if(groundEnemy instanceof Goblin)
        {
            barX+=15/GameWorld.PPM;
            barY += 25/GameWorld.PPM;

        }
        else
            barY += 25/GameWorld.PPM;




        // Vẽ nền thanh máu
        batch.draw(bgTexture, barX, barY, barWidth, barHeight);

        // Vẽ thanh máu đỏ
        batch.draw(redTexture, barX, barY, barWidth * healthPercentage, barHeight);
    }

    public void dispose() {
        bgTexture.dispose();
        redTexture.dispose();
    }
}

