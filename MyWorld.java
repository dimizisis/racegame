
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
    
    /**
     * Constructor for objects of class MyWorld.
     */
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
    
    /**
    * Returns the string representation of the current level.
    *
    * @return      the string representation of the current level.
    */
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
     
        setPaintOrder(ScoreBoard.class, WarningMessage.class, Speedometer.class, Car.class, OtherCar.class, Road.class);
        
        addObject(new ScoreBoard("Score: ", level), 50, 20, false);
        addObject(new Speedometer(mainActor), 520, 20, false);
        
    }
    
    /**
    * Generates all the needed objects, based on the current level.
    */
    private void generateObjects()
    {
        if (level.equals("crossings"))
            generateCrossings(5);
        else if (level.equals("speed_limits"))
            generateSpeedLimitSigns(4);
        else if (level.equals("stop_sign"))
            generateRoads(5);
        else if (level.equals("cumulative"))
        {
            generateCrossings(new int[]{-1900, 1000, 2200});
            generateSpeedLimitSigns(new int[]{-500, 400, 1000, 1850});
            generateRoads(new int[]{-1000, 0, 1500});
        }
        generateOtherCars();
    }
    
    /**
    * Generates (randomly) speed limit signs, with a count provided.
    *
    * @param  count  an integer representing the total number of generated speed signs.
    */
    private void generateSpeedLimitSigns(int count)
    {
        int x = -1900;
        for (int i=1; i <= count; ++i)
        {
            int speedLimit = ThreadLocalRandom.current().nextBoolean() ? 30 : 55;
            String speedLimitImg = "speed_limit_" + speedLimit;
            x = ThreadLocalRandom.current().nextInt(x+200*i, x+300*i);
            SpeedSign ss = new SpeedSign(speedLimitImg);
            speedLimits.add(new SpeedLimitRange(x, speedLimit, ss));
            addObject(ss, x, 768);
            if (speedLimits.size() > 1)
                speedLimits.get(speedLimits.size()-2).setStopX(x);
        }
    }
    
    /**
    * Generates speed limit signs, given the specific widths.
    *
    * @param  count  an integer representing the total number of generated speed signs.
    */
    private void generateSpeedLimitSigns(int[] widths)
    {
        for (int i=0; i < widths.length; ++i)
        {
            int speedLimit = ThreadLocalRandom.current().nextBoolean() ? 30 : 55;
            String speedLimitImg = "speed_limit_" + speedLimit;
            SpeedSign ss = new SpeedSign(speedLimitImg);
            if (i < widths.length-1)
                speedLimits.add(new SpeedLimitRange(widths[i], widths[i+1], speedLimit, ss));
            else
                speedLimits.add(new SpeedLimitRange(widths[i], speedLimit, ss));
            addObject(ss, widths[i], 768);
        }
    }
    
    /**
    * Generates (randomly) crossings, with a count provided.
    * Some of the crossings may contain speed lights and all of the crossings have
    * pedestrians crossing them.
    *
    * @param  count  an integer representing the total number of generated crossings.
    */
    private void generateCrossings(int count)
    {
        boolean hasPedestrians = true;
        int x = -1900;
        for (int i=1; i <= count; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(x+200*(i+2), x+300*(i+2));
            Crossing crossing = new Crossing(hasPedestrians);
            addObject(crossing, x, 420);
            if (i % 2 == 0)
                crossing.addTrafficLight();
        }
    }
    
    /**
    * Generates crossings, given the specific widths.
    * Some of the crossings may contain speed lights and all of the crossings have
    * pedestrians crossing them.
    *
    * @param  widths  an integer array representing the specific widths for each crossing.
    */
    private void generateCrossings(int widths[])
    {
        boolean hasPedestrians = true;
        for (int i=0; i < widths.length; ++i)
        {
            Crossing crossing = new Crossing(hasPedestrians);
            addObject(crossing, widths[i], 420);
            if (i % 2 == 0)
                crossing.addTrafficLight();
        }
    }
    
    /**
    * Generates (randomly) roads, with a count provided.
    * All of the vertical roads contain stop signs.
    *
    * @param  count  an integer representing the total number of generated (vertical) roads.
    */
    private void generateRoads(int count)
    {
        boolean hasPedestrians = ThreadLocalRandom.current().nextBoolean();
        int x = -1900;
        for (int i=1; i <= count; ++i)
        {
            x = ThreadLocalRandom.current().nextInt(x+200*(i+2), x+300*(i+2));
            Road road = new Road();
            addObject(road, x, 420);
            addObject(new StopSign(), x-210, 768);
            generateOtherCars(x, 600, true);
        }
    }
    
    /**
    * Generates (vertical) roads, given the specific widths.
    * All of the vertical roads contain stop signs.
    *
    * @param  widths  an integer array representing the specific widths for each (vertical) road.
    */
    private void generateRoads(int widths[])
    {
        boolean hasPedestrians = ThreadLocalRandom.current().nextBoolean();
        for (int i=0; i < widths.length; ++i)
        {
            Road road = new Road();
            addObject(road, widths[i], 420);
            addObject(new StopSign(), widths[i]-210, 768);
            generateOtherCars(widths[i], 600, true);
        }
    }
    
    /**
    * Generates (randomly) other cars (autocontrolled), given the specific width, height.
    *
    * @param  width  in what width should the cars be generated
    * @param  height  in what width should the cars be generated
    * @param  vertical  if the cars are moving vertically or not
    */
    private void generateOtherCars(int width, int height, boolean vertical)
    {
        for (int i=1; i<=1; ++i)
            addObject(new OtherCar(2, vertical), width+3*i, height);
    }
    
    /**
    * Generates (randomly) other cars (autocontrolled)
    *
    */
    private void generateOtherCars()
    {
        for (int i=0; i<4; ++i)
            addObject(new OtherCar(i+1), ThreadLocalRandom.current().nextInt(-1000, 2200), ThreadLocalRandom.current().nextInt(120, 420));
    }
    
    /**
    * Returns all the speed limit ranges that exist in the level.
    *
    */
    public List<SpeedLimitRange> getSpeedLimits()
    {
        return this.speedLimits;
    }
    
    /**
    * Shows a warning regarding to the high speed of main actor.
    * Appears only when the main actor (car) exceeds the limits.
    *
    */
    public void showSpeedWarning()
    {
        addObject(Language.getInstance().getSelectedLanguage().equals("en") ? new WarningMessage("Warning!", "Slow down!") : new WarningMessage("Προσοχή!", "Περιόρισε ταχύτητα!"), getWidth()/2, getHeight()/2, false);
    }
    
    /**
    * Disposes the warning regarding to the high speed of main actor.
    * Triggered only when the main actor (car) slows down and bounds
    * its speed to the permitted limit.
    *
    */
    public void disposeSpeedWarning()
    {
        this.removeObjects(getObjects(WarningMessage.class));
    }
    
    /**
    * Does all the actions needed when the game ends.
    * (flushes the scores to file, shows appropriate message, etc)
    * and returns the user to MainMenu screen.
    *
    * @param  success  if the game ended with success or not
    */
    public void gameEnd(boolean success)
    {
        if (success)
            Score.getInstance().flushScoreToFile(level);
        String title = success ? "Congratulations!" : "Game Over";
        String prefix = success ? "Score: " : "";
        addObject(new ScoreBoard(title, prefix, level, success), getWidth()/2, getHeight()/2, false);
        Lives.getInstance().resetLives();
        Score.getInstance().resetScore(level);
        if (success)
            Settings.getInstance().updateCarAvailability();
        Statistics.getInstance().flushStatsToFile();
        Greenfoot.delay(400);
        Greenfoot.setWorld(new MainMenu());
    }
}
