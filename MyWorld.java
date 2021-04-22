
import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class MyWorld here.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class MyWorld extends SWorld
{
    private int level = 1;
    
    private Map objectsCount;
    
    public MyWorld(int level)
    {
        super(600, 840, 1, 5000);
        prepare();
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x840 cells with a cell size of 1x1 pixels.
        super(600, 840, 1, 5000);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Greenfoot.playSound("start.wav");
        //Greenfoot.playSound("spyhunter.wav");
        setMainActor(new Car(), 50, 500);      
        mainActor.setLocation(-3000, 510);
        setScrollingBackground(new GreenfootImage("track.png"));
        
        if (Sound.getInstance().isSoundOn())
            Greenfoot.playSound("spyhunter.wav");
        
        generateRandomCones(5);
        generateRandomOils(5);
        generateRandomCrossings(2, true);
        
        setPaintOrder(Oil.class, Cone.class);
        setPaintOrder(Cone.class, Car.class);
    }
    
    private void generateRandomCones(int count)
    {
        int x, prevX = 0;
        for (int i=0; i < count; ++i)
        {  
            x = ThreadLocalRandom.current().nextInt(-1900, 2500);
            addObject(new Cone(), x + prevX, ThreadLocalRandom.current().nextInt(120, 700));
            prevX = x;
        }
    }
    
    private void generateRandomOils(int count)
    {
        int x, prevX = 0;
        for (int i=0; i < count; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(-1900 + prevX, 2500);
            addObject(new Oil(), x, ThreadLocalRandom.current().nextInt(420, 700));
            prevX = x;
        }
    }
    
    private void generateRandomCrossings(int count, boolean withPedestrians)
    {
        int x, prevX = 0;
        for (int i=0; i < count; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(-1900 + prevX, 2500);
            Crossing crossing = new Crossing(1);
            addObject(crossing, x, 420);
            crossing.addTrafficLight();
            prevX = x;
        }
    }
    
    public void gameOver() 
    {
        setPaintOrder(ScoreBoard.class);
        addObject(new ScoreBoard(Score.getInstance().getScore("level" + level)), getWidth()/2, getHeight()/2);
    }
}
