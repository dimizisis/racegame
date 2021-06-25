import greenfoot.*;
import java.util.Objects;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Class that represents a Car, which is the main actor of the game.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Car extends SmoothMover 
{
    public final static int SPEED_LIMIT = 6;
    private Set<Actor> stopped;
    private Set<Actor> passed;

    /**
     * Constructor for objects of class Car.
     */
    public Car() 
    {
        setImage(new GreenfootImage(Settings.getInstance().getSelectedCar()));
        if (Settings.getInstance().getSelectedCar().contains("Car_2"))
            getImage().rotate(180);
        stopped = new HashSet<>();
        passed = new HashSet<>();
    }

    /**
     * Act - do whatever the Car wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if (collisionDetected()) 
        {
            Score.getInstance().reduceLevelScore(((MyWorld) getWorld()).getLevel());
            Lives.getInstance().reduceLives();
            Statistics.getInstance().incrementCollisions();
            if (Lives.getInstance().getLivesCount() > 0)
                respawn();
            else
                end(false, true);
        }

        if (passedWithRedLight())
        {
            Lives.getInstance().reduceLives();
            Statistics.getInstance().incrementCrossingViolations();
            if (Lives.getInstance().getLivesCount() < 1)
                end(false, false);
        }

        SpeedSign ss = speedViolationDetected();
        if (Objects.nonNull(ss)) 
        {
            if (!passed.contains(ss)) {
                Score.getInstance().reduceLevelScore(((MyWorld) getWorld()).getLevel());
                Statistics.getInstance().incrementSpeedViolations();
            }
            passed.add(ss);
            ((MyWorld) getWorld()).showSpeedWarning();
        } 
        else 
        {
            ((MyWorld) getWorld()).disposeSpeedWarning();
        }

        if (Greenfoot.isKeyDown("left")) 
        {
            moveBackwards();
        }

        if (Greenfoot.isKeyDown("right")) 
        {
            moveForward();
        }

        if (Greenfoot.isKeyDown("up")) 
        {
            moveUp();
        }

        if (Greenfoot.isKeyDown("down")) 
        {
            moveDown();
        }

        if (Greenfoot.isKeyDown("b")) 
        {
            stop();
            if (stoppedBeforeCrossing() || stoppedBeforeRoad()) 
            {
                Sound.getInstance().playWellDone();
                Score.getInstance().increaseLevelScore(((MyWorld) getWorld()).getLevel());
            }
        }

        if (Greenfoot.isKeyDown("h")) 
        {
            Sound.getInstance().playHorn();
            warnPedestrians();
        }

        if (reachedEnd()) 
        {
            if (Score.getInstance().getScore(((MyWorld) getWorld()).getLevel()) > 0)
                end(true, false);
            else
                end(false, false);
        }

    }
    
    /**
     * Checks if speed violations occured.
     * @return  the speed sign instance, whose limit was violated if violation occured, null otherwise
     */
    private SpeedSign speedViolationDetected() 
    {
        SpeedSign ss = null;
        for (SpeedLimitRange speedLimitRange : ((MyWorld) getWorld()).getSpeedLimits()) 
        {
            if (((MyWorld) getWorld()).getScrolledX() + getX() >= speedLimitRange.getStartX() && ((MyWorld) getWorld()).getScrolledX() <= speedLimitRange.getStopX() + getX()) 
            {
                if (hasExceededSpeedLimit(speedLimitRange.getSpeedLimit())) 
                {
                    ss = speedLimitRange.getSpeedSign();
                    break;
                }
            }
        }
        return ss;
    }
    
    /**
     * Checks if the car instance exceeded a given speed limit (double).
     * @return  true if the car has exceeded the given limit, false otherwise.
     */
    public boolean hasExceededSpeedLimit(double speedLimit) 
    {
        if (Math.abs(this.getSpeed() * 10) >= speedLimit)
            return true;
        return false;
    }
    
    /**
     * Moves the car backwards. Triggered when the left arrow is pressed.
     */
    private void moveBackwards() 
    {
        if (getSpeed() > -SPEED_LIMIT)
            getMovement().setLength(getMovement().getLength() - 0.2);
    }
    
    /**
     * Moves the car forward. Triggered when the right arrow is pressed.
     */
    private void moveForward() 
    {
        if (getSpeed() < SPEED_LIMIT)
            getMovement().setLength(getMovement().getLength() + 0.2);
    }
    
    /**
     * Moves the car up. Triggered when the up arrow is pressed.
     */
    private void moveUp() 
    {
        if (canGoUp()) 
        {
            double currSpeed = getSpeed();
            stop();
            setRotation(getRotation() - 2);
            addForce(new Vector(getRotation(), currSpeed));
        }
    }
    
    /**
     * Moves the car down. Triggered when the down arrow is pressed.
     */
    private void moveDown() 
    {
        if (canGoDown()) 
        {
            double currSpeed = getSpeed();
            stop();
            setRotation(getRotation() + 2);
            addForce(new Vector(getRotation(), currSpeed));
        }
    }
    
    /**
     * Warns pedestrians to move away. Triggered when car horn is pressed (Key: H).
     */
    private void warnPedestrians() 
    {
        List<Crossing> crossings = getObjectsInRange(200, Crossing.class);
        List<Pedestrian> pedestriansInRange = getObjectsInRange(350, Pedestrian.class);
        if (!crossings.isEmpty()) {
            if (!pedestriansInRange.isEmpty()) {
                for (Crossing cr : crossings) {
                    if ((cr.hasTrafficLight() && cr.getTrafficLight().getState() == 1) || !cr.hasTrafficLight()) {
                        pedestriansInRange.forEach(Pedestrian::increaseSpeed);
                    }
                }
            }
        }
    }
    
    /**
     * Checks if a collision has occured.
     * 
     * @return  true if a collision detected, false otherwise.
     */
    private boolean collisionDetected() 
    {
        Actor pedestrian = getOneIntersectingObject(Pedestrian.class);
        Actor otherCar = getOneIntersectingObject(OtherCar.class);
        if (collidesWith(pedestrian) || collidesWith(otherCar)) 
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the car passes with red light.
     * 
     * @return  true if a passed with red light, false otherwise.
     */
    private boolean passedWithRedLight() 
    {
        Crossing crossing = (Crossing) getOneIntersectingObject(Crossing.class);
        if (Objects.nonNull(crossing) && crossing.hasTrafficLight() && crossing.getTrafficLight().getState() == 0) 
        {
            if (!passed.contains(crossing)) 
            {
                passed.add(crossing);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the car stopped before a crossing (plus points).
     * 
     * @return  true if the car stopped before a crossing, false otherwise.
     */
    private boolean stoppedBeforeCrossing() 
    {
        Crossing crossing = (Crossing) getOneIntersectingObject(Crossing.class);
        List<? extends Actor> actorsInRange = getObjectsInRange(200, Crossing.class);
        if (!actorsInRange.isEmpty() && Objects.isNull(crossing)) 
        {
            for (Actor a : actorsInRange) 
            {
                if (getX() < a.getX()) 
                {
                    if (!stopped.contains(a)) 
                    {
                        stopped.add(a);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Checks if the car stopped before a (vertical) road (plus points).
     * 
     * @return  true if the car stopped before a (vertical) road, false otherwise.
     */
    private boolean stoppedBeforeRoad() 
    {
        Road road = (Road) getOneIntersectingObject(Road.class);
        List<? extends Actor> actorsInRange = getObjectsInRange(330, Road.class);
        if (!actorsInRange.isEmpty() && Objects.isNull(road)) 
        {
            for (Actor a : actorsInRange) 
            {
                if (getX() < a.getX()) 
                {
                    if (!stopped.contains(a)) 
                    {
                        stopped.add(a);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Checks if the car has reached the end of the road (an the level).
     * 
     * @return  true if the car has reached the end of the road, false otherwise.
     */
    private boolean reachedEnd() 
    {
        return this.getX() >= 520 ? true : false;
    }
    
    /**
     * Does all the needed actions when the car reached end.
     * Sets the exploded GIF as the actor's images if crashed
     * before the game ended (and wasted all the lives).
     */
    private void end(boolean success, boolean crashed) 
    {
        stop();
        if (crashed)
            setImage(new GreenfootImage("explode.gif"));
        ((MyWorld) getWorld()).gameEnd(success);
    }
    
    /**
     * Checks if the car is within the vertical limits (in the upside).
     * 
     * @return  true if the car is within the vertical limits, false otherwise.
     */
    private boolean canGoUp() 
    {
        if (getY() > 140)
            return true;
        return false;
    }
    
    /**
     * Checks if the car is within the vertical limits (in the downside).
     * 
     * @return  true if the car is within the vertical limits, false otherwise.
     */
    private boolean canGoDown() 
    {
        if (getY() < 700)
            return true;
        return false;
    }
    
    /**
     * Checks if the car collides with an actor.
     * 
     * @return  true if the car collides with an actor, false otherwise.
     */
    private boolean collidesWith(Actor a) 
    {
        if (a == null || (a != null && getX() > a.getX()))
            return false;
        return true;
    }
    
    /**
     * Respawns the car. Triggers after a crash, if there are lives available.
     */
    private void respawn() 
    {
        Sound.getInstance().playBreaking();
        setLocation(getX() + 150, getY());
        for (int i = 0; i < 2; ++i) 
        {
            GreenfootImage img = getImage();
            int t = img.getTransparency();
            img.setTransparency(0);
            Greenfoot.delay(50);
            img.setTransparency(t);
            Greenfoot.delay(50);
        }
    }
}
