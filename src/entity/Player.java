package entity;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            System.out.println("Image loading started");
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_up_1.PNG"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_up_2.PNG"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_down_1.PNG"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_down_2.PNG"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_left_1.PNG"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_left_2.PNG"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_right_1.PNG"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_right_2.PNG"));
            System.out.println("Image loading ended");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }

    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
