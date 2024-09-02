import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile, Default size of characters
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile size now.
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixe;s
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    Thread gameThread;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this); //passing in GamepNale class to constructor
        gameThread.start(); //calls run()
    }

    //creating game loop in run method
    @Override
    public void run() {
        while(gameThread != null){
            System.out.println("Game loop running.");
        }
        
    }
}
