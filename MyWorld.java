
import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;
import java.util.HashMap;

/**
 * World of every level.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class MyWorld extends SWorld
{
    private String level = "crossings";
    private GreenfootImage backgroundImage = new GreenfootImage("track.png");
    private Car mainActor = new Car();
    
    public MyWorld(String level)
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
        super(600, 840, 1, 5000);
        prepare();
    }
    
    public String getLevel()
    {
        return this.level;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setMainActor(mainActor, 50, 500);      
        mainActor.setLocation(-3000, 510);
        setScrollingBackground(this.backgroundImage);
        
        setPaintOrder(ScoreBoard.class);
        addObject(new ScoreBoard("Score: ", level), 50, 20, false);
        addObject(new Speedometer(mainActor), 520, 20, false);
        
        generateObjects();
        
        //Sound.getInstance().playLevelMusic();

        setPaintOrder(Oil.class, Cone.class);
        setPaintOrder(Cone.class, Car.class);
        setPaintOrder(ScoreBoard.class);
    }
    
    private void generateObjects()
    {
        generateRandomCrossings();
        //generateRandomCones();
        //generateRandomOils();
        generateOtherCars();
    }
    
    private void generateOtherCars()
    {
        for (int i=0; i<4; ++i)
            addObject(new OtherCar(2), ThreadLocalRandom.current().nextInt(-1000, 2500), ThreadLocalRandom.current().nextInt(120, 700));
    }
    
    private void generateRandomCones()
    {
        int count = 3; /* generate according to the level */
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
        int count = 3; /* generate according to the level */
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
        boolean hasPedestrians = true;
        int x, prevX = 0;
        for (int i=0; i < 3; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(-2000 + prevX, 3000);
            Crossing crossing = new Crossing(hasPedestrians);
            addObject(crossing, x, 420);
            if (i % 2 == 0)
                crossing.addTrafficLight();
            prevX = x;
        }
    }
    
    public void gameEnd(boolean success)
    {
        if (success)
            Score.getInstance().flushScoreToFile(level);
        String title = success ? "Congratulations!" : "Game Over";
        String prefix = success ? "Score: " : "";
        addObject(new ScoreBoard(title, prefix, level, success), getWidth()/2, getHeight()/2, false);
        Sound.getInstance().stopLevelMusic();
        Lives.getInstance().resetLives();
        Score.getInstance().resetScore(level);
        if (success)
            Settings.getInstance().updateCarAvailability();
        Greenfoot.delay(400);
        Greenfoot.setWorld(new MainMenu());
    }
}
