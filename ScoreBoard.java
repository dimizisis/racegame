import greenfoot.*;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 38.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    int score;
    
    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        this.score = score;
        makeImage("Game Over", "Score: ", score);
    }
    
    public ScoreBoard(String title,int score)
    {
        this.score = score;
        makeImage(title, "Score: ", score);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 160);
        image.drawString("click to continue" , 60, 220);
        setImage(image);
    }
    
    public void act(){
        if (Greenfoot.mousePressed(this))
        {
            //((MyWorld) getWorld()).backgroundSound.stop();  // stop music
            Greenfoot.setWorld(new MainMenu(score));   // go to UI
        }
    }
}
