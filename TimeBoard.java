import greenfoot.*;

/**
 * The TimeBoard is used to display remaining time & lives on the screen. It can display some
 * text and several numbers.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class TimeBoard extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 260;
    public static final int HEIGHT = 330;
    
    private int time;
    private String prefix;
    
    public TimeBoard()
    {
        this.prefix = "Time: ";
        this.time = 0;
        makeImage();
    }
    
    public TimeBoard(int initTimerVal)
    {
        this.prefix = "Time: ";
        this.time = initTimerVal;
        makeImage();
    }
    
    /**
     * Make the score board image.
     */
    private void makeImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255, 255, 255, 128));
        image.fillRect(0, 0, WIDTH-30, HEIGHT-80);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-30, HEIGHT-80);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(this.prefix + this.time/100 + "\nLives: " + Lives.getInstance().getLivesCount(), 60, 190);
        setImage(image);
    }
    
    private void updateTimer()
    {
        --this.time;
    }
    
    public void act(){
        makeImage();
        updateTimer();
        if (this.time <= 0)
            ((MyWorld) getWorld()).gameEnd(false);
    }   
}
