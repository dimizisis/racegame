import greenfoot.*;
import java.util.Calendar;

/**
 * The WarningMessage is used to display warnings on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling (original author of ScoreBoard, from which the Speedometer class is derived)
 * @version 1.0
 */
public class WarningMessage extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    
    private String text;
    private String messageType;
    
    /**
     * Constructor for objects of class WarningMessage.
     * 
     * @param text  the text of the warning
     * @param messageType  the type of the warning (like a title)
     */
    public WarningMessage(String text, String messageType)
    {
        this.text = text;
        this.messageType = messageType;
        makeInfoImage();
    }

    /**
     * Makes the warning image.
     */
    private void makeInfoImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(messageType, 60, 70);
        image.drawString(text, 60, 130);
        setImage(image);
    }
    
    /**
     * Act - do whatever the WarningMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    { 
    }

}
