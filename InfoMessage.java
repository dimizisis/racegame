import greenfoot.*;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
 */
public class InfoMessage extends Actor
{
    public static final float FONT_SIZE = 30.0f;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 840;
    
    int score;
    
    /**
     * Create a score board for the final result.
     */
    public InfoMessage(String text)
    {
        this.score = score;
        makeInfoImage("Information", text);
    }

    /**
     * Make the information image.
     */
    private void makeInfoImage(String title, String message)
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
        image.drawString(title, 150, 100);
        image.drawString(message, 150, 160);
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
