import greenfoot.*;
import java.util.Calendar;

/**
 * The InfoMessage is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling (original author of ScoreBoard, from which the InfoMessage class is derived)
 * @version 1.0
 */
public class InfoMessage extends Actor
{
    public static final float FONT_SIZE = 20.0f;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 840;
    
    /**
     * Constructor for objects of class InfoMessage.
     * @param text  the string representation of the message
     */
    public InfoMessage(String text)
    {
        makeInfoImage("Information", text);
    }

    /**
     * Makes the information image.
     * 
     * @param title   the string representation of the title of the information message
     * @param message   the string representation of the message
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
    
    /**
     * Act - do whatever the InfoMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new MainMenu());   // go to Menu
        }
    }
}
