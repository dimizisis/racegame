
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
        this.level = level;
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
        setMainActor(new Car(), 50, 500);      
        mainActor.setLocation(-3000, 510);
        setScrollingBackground(new GreenfootImage("track.png"));
        
        setPaintOrder(ScoreBoard.class);
        addObject(new ScoreBoard("Score: ", Score.getInstance().getScore("level" + level)), 50, 20, false);
        
        Sound.getInstance().playLevelMusic();
        
        generateObjects();
        
        setPaintOrder(Oil.class, Cone.class);
        setPaintOrder(Cone.class, Car.class);
    }
    
    private void generateObjects()
    {
        generateRandomCrossings();
        generateRandomCones();
        generateRandomOils();
    }
    
    private void generateRandomCones()
    {
        int count = this.level * 5; /* generate according to the level */
        int x, prevX = 0;
        for (int i=0; i < count; ++i)
        {  
            x = ThreadLocalRandom.current().nextInt(-1900, 2500);
            addObject(new Cone(), x + prevX, ThreadLocalRandom.current().nextInt(120, 700));
            prevX = x;
        }
    }
    
    private void generateRandomOils()
    {
        int count = this.level * 5; /* generate according to the level */
        int x, prevX = 0;
        for (int i=0; i < count; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(-1900 + prevX, 2500);
            addObject(new Oil(), x, ThreadLocalRandom.current().nextInt(420, 700));
            prevX = x;
        }
    }
    
    private void generateRandomCrossings()
    {
        int count = this.level; /* generate according to the level */
        boolean hasPedestrians = this.level > 1 ? true : false;
        int x, prevX = 0;
        for (int i=0; i < count; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(-1900 + prevX, 2500);
            Crossing crossing = new Crossing(hasPedestrians);
            addObject(crossing, x, 420);
            crossing.addTrafficLight();
            prevX = x;
        }
    }
    
    public void gameOver() 
    {
        setPaintOrder(ScoreBoard.class);
        addObject(new ScoreBoard(Score.getInstance().getScore("level" + level)), getWidth()/2, getHeight()/2, false);
        Sound.getInstance().stopLevelMusic();
        Lives.getInstance().resetLives();
        Score.getInstance().flushScoreToFile();
    }
}
