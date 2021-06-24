import greenfoot.*;

/**
 * The LiveBoard is used to display remaining lives on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling (original author of ScoreBoard, from which the LiveBoard class is derived)
 * @version 1.0
 */
public class LiveBoard extends Actor
{
    public static final float FONT_SIZE = 20.0f;
    public static final int WIDTH = 260;
    public static final int HEIGHT = 330;
    
    private String prefix;
    
    /**
     * Constructor for objects of class LiveBoard.
     */
    public LiveBoard()
    {
        this.prefix = "Lives: ";
        makeImage();
    }
    
    /**
     * Makes the time board image.
     */
    private void makeImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255, 255, 255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT-275);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH, HEIGHT-275);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(this.prefix + Lives.getInstance().getLivesCount(), 70, 40);
        setImage(image);
    }
    
    /**
     * Act - do whatever the TimeBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        makeImage();
    }    
}
