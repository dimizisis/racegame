import greenfoot.*;
import java.text.DecimalFormat;

/**
 * The Speedometer is used to display the main actor's speed on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling (original author of ScoreBoard, from which the Speedometer class is derived)
 * @version 1.0
 */
public class Speedometer extends Actor
{
    public static final float FONT_SIZE = 20.0f;
    public static final int WIDTH = 260;
    public static final int HEIGHT = 330;
    
    private int time;
    private String prefix;
    private Car car;
    
    /**
     * Constructor for objects of class Speedometer.
     * 
     * @param c  the car, whose speed will be showing.
     */
    public Speedometer(Car c)
    {
        this.car = c;
        this.prefix = "Speed: ";
        this.time = 0;
        makeImage();
    }
    
    /**
     * Makes the speedometer image.
     */
    private void makeImage()
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 128));
        image.fillRect(0, 0, WIDTH-30, HEIGHT-150);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-30, HEIGHT-150);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        if (((MyWorld) getWorld()) != null)
            image.drawString(this.prefix + new DecimalFormat("#0.00").format(this.car.getSpeed()*10) + " km/h\n ", 35, 170);
        setImage(image);
    }
    
    public void act()
    {
        makeImage();
    }
    
}
