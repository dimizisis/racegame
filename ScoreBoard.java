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
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public boolean inGameScore = false;
    
    private String prefix;
    private String title;
    private String level;
    
    public ScoreBoard(String title, String prefix, String level, boolean success)
    {
        this.title = title;
        this.prefix = prefix;
        this.level = level;
        makeEndImage(success);
    }
    
    public ScoreBoard(String prefix, String level)
    {
        this.prefix = prefix;
        this.level = level;
        this.inGameScore = true;
        makeImage();
    }

    /**
     * Make the score board image.
     */
    private void makeEndImage(boolean success)
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
        if (success)
            image.drawString(prefix + Score.getInstance().getScore(this.level) + "\nDirecting you to main menu...", 60, 160);
        else
            image.drawString(prefix + "\nDirecting you to main menu...", 60, 160);
        setImage(image);
    }
    
    /**
     * Make the score board image.
     */
    private void makeImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255, 255, 255, 128));
        image.fillRect(0, 0, WIDTH-65, HEIGHT-80);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-65, HEIGHT-80);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(prefix + Score.getInstance().getScore(level), 165, 162);
        image.drawString("Max Score: " + Score.getInstance().getMaxScoreForLevel(level), 162, 200);
        setImage(image);
    }
    
    public void act(){
        if (Greenfoot.mousePressed(this))
        {
            if (!inGameScore)
                Greenfoot.setWorld(new MainMenu());   /* go to Main Menu */
        }
        makeImage();
    }
}
