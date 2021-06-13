
import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
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
    private Car mainActor;
    private List<SpeedLimitRange> speedLimits = new ArrayList<>();
    
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
        generateObjects();
        
        mainActor = new Car();
        setMainActor(mainActor, 50, 500);      
        mainActor.setLocation(-2200, 510);
        
        setScrollingBackground(this.backgroundImage);
        
        setPaintOrder(ScoreBoard.class);
        addObject(new ScoreBoard("Score: ", level), 50, 20, false);
        addObject(new Speedometer(mainActor), 520, 20, false);

        //Sound.getInstance().playLevelMusic();
        setPaintOrder(WarningMessage.class, Cone.class);
        setPaintOrder(Cone.class, Car.class);
        setPaintOrder(ScoreBoard.class);
    }
    
    private void generateObjects()
    {
        if (level.equals("crossings"))
            generateRandomCrossings();
        else if (level.equals("speed_limits"))
            generateRandomSpeedLimitSigns();
        //generateRandomOils();
        //generateOtherCars();
    }
    
    private void generateOtherCars()
    {
        for (int i=0; i<4; ++i)
            addObject(new OtherCar(2), ThreadLocalRandom.current().nextInt(-1000, 2200), ThreadLocalRandom.current().nextInt(120, 700));
    }
    
    private void generateRandomSpeedLimitSigns()
    {
        int x = getScrolledX();
        for (int i=0; i < 4; ++i)
        {
            int speedLimit = ThreadLocalRandom.current().nextBoolean() ? 30 : 55;
            String speedLimitImg = "speed_limit_" + speedLimit;
            x = ThreadLocalRandom.current().nextInt(x+200, x+400);
            speedLimits.add(new SpeedLimitRange(x, speedLimit));
            addObject(new SpeedSign(speedLimitImg), x, 768);
            if (speedLimits.size() > 1)
                speedLimits.get(speedLimits.size()-2).setStopX(x);
        }
        int xx = 60, yy = 160;
        for (SpeedLimitRange speedLimitRange : speedLimits)
        {
            showText(speedLimitRange.getStartX() + " " + speedLimitRange.getStopX(), xx, yy);
            xx+=30;
            yy+=30;
        }
    }
    
    private void generateRandomCrossings()
    {
        boolean hasPedestrians = true;
        int x = getScrolledX();
        for (int i=0; i < 3; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(x+300, 2200);
            Crossing crossing = new Crossing(hasPedestrians);
            addObject(crossing, x, 420);
            if (i % 2 == 0)
                crossing.addTrafficLight();
        }
    }
    
    public List<SpeedLimitRange> getSpeedLimits()
    {
        return this.speedLimits;
    }
    
    public void showSpeedWarning()
    {
        addObject(Language.getInstance().getSelectedLanguage().equals("en") ? new WarningMessage("Warning!", "Slow down!") : new WarningMessage("Προσοχή!", "Περιόρισε ταχύτητα!"), getWidth()/2, getHeight()/2, false);
    }
    
    public void removeSpeedWarning()
    {
        this.removeObjects(getObjects(WarningMessage.class));
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
