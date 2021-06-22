import greenfoot.*;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling (modified by Dimitrios Zisis)
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public boolean inGameScore = false; /* if it is in-game score, no need for title */
    
    private String prefix;
    private String title;
    private String level;
    
    /**
     * Constructor for objects of class ScoreBoard.
     * 
     * @param title  the title of the scoreboard
     * @param prefix  the prefix of the message (within the scoreboard)
     * @param level  the current level that the score reffers to
     * @param success  whether or not the game ended with success
     */
    public ScoreBoard(String title, String prefix, String level, boolean success)
    {
        this.title = title;
        this.prefix = prefix;
        this.level = level;
        makeEndImage(success);
    }
    
    /**
     * Constructor for objects of class ScoreBoard.
     * @param prefix  the prefix of the message (within the scoreboard)
     * @param level  the current level that the score reffers to
     */
    public ScoreBoard(String prefix, String level)
    {
        this.prefix = prefix;
        this.level = level;
        this.inGameScore = true;
        makeImage();
    }

    /**
     * Makes the score board image.
     * @param success  whether or not the game ended with success
     */
    private void makeEndImage(boolean success)
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
        image.drawString(title, 60, 100);
        if (success)
            image.drawString(prefix + Score.getInstance().getScore(this.level) + "\nDirecting you to main menu...", 60, 160);
        else
            image.drawString(prefix + "\nDirecting you to main menu...", 60, 160);
        setImage(image);
    }
    
    /**
     * Makes the score board image.
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
    
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            if (!inGameScore)
                Greenfoot.setWorld(new MainMenu());   /* go to Main Menu */
        }
        makeImage();
    }
}
