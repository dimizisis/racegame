    import greenfoot.*;
    import java.util.Objects;
    import java.util.List;
    import java.util.Set;
    import java.util.HashSet;
    /**
     * Write a description of class Car here.
     * 
     * @author Dimitrios Zisis 
     * @version 1.0
     */
    public class Car extends SmoothMover
    {
<<<<<<< Updated upstream
        private final static int SPEED_LIMIT = 5;
=======
        private final static int SPEED_LIMIT = 6;
>>>>>>> Stashed changes
        private Set<Actor> stopped;
        private Set<Actor> passed;
        
        public Car()
        {
            setImage(new GreenfootImage(Settings.getInstance().getSelectedCar()));
            if (Settings.getInstance().getSelectedCar().contains("Car_2"))
                getImage().rotate(180);
            stopped = new HashSet<>();
            passed = new HashSet<>();
        }
        
        /**
         * Act - do whatever the Car wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {

            move();
            checkCollisions();
            checkTrafficLight();
<<<<<<< Updated upstream
=======
            checkSpeedLimits();
>>>>>>> Stashed changes
            
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
<<<<<<< Updated upstream
                checkIfStoppedBeforeCrossing();
=======
                if (checkIfStoppedBeforeCrossing())
                    Sound.getInstance().playWellDone();
>>>>>>> Stashed changes
            }
            
            if (Greenfoot.isKeyDown("h"))
            {
                Sound.getInstance().playHorn();
                warnPedestrians();
            }
                
            if (reachedEnd())
            {
                end(true);
            }
            
    }
    
<<<<<<< Updated upstream
    private void moveBackwards()
    {
        stop();
        addForce (new Vector(getRotation(), -0.2));
    }
    
    private void moveForward()
    {
        if (getSpeed() < SPEED_LIMIT)
        {
            addForce (new Vector(getRotation(), 0.2));
        }
    }
    
    private void moveUp()
    {
        if (canGoUp())
        {
            double currSpeed = getSpeed();
            stop();
            setRotation(getRotation() - 2);
            addForce (new Vector(getRotation(), currSpeed));
        }
    }
    
=======
    private void checkSpeedLimits()
    {
        for (SpeedLimitRange speedLimitRange : ((MyWorld) getWorld()).getSpeedLimits())
        {
            if (((MyWorld) getWorld()).getScrolledX()+getX() >= speedLimitRange.getStartX() && ((MyWorld) getWorld()).getScrolledX() <= speedLimitRange.getStopX()+getX())
            {
                if (hasExceededSpeedLimit(speedLimitRange.getSpeedLimit()))
                {
                    Score.getInstance().reduceLevelScore(((MyWorld) getWorld()).getLevel());
                    ((MyWorld) getWorld()).showSpeedWarning();
                }
                else
                {
                    ((MyWorld) getWorld()).removeSpeedWarning();
                }
            }
            else
            {
                ((MyWorld) getWorld()).removeSpeedWarning();
            }
        }
    }
    
    public boolean hasExceededSpeedLimit(double speedLimit)
    {
        if (Math.abs(this.getSpeed()*10) >= speedLimit)
            return true;
        return false;
    }
    
    private void moveBackwards()
    {
        if (getSpeed() > -SPEED_LIMIT)
        {
            getMovement().setLength(getMovement().getLength() - 0.2);
        }
    }
    
    private void moveForward()
    {
        if (getSpeed() < SPEED_LIMIT)
        {
            getMovement().setLength(getMovement().getLength() + 0.2);
        }
    }
    
    private void moveUp()
    {
        if (canGoUp())
        {
            double currSpeed = getSpeed();
            stop();
            setRotation(getRotation() - 2);
            addForce (new Vector(getRotation(), currSpeed));
        }
    }
    
>>>>>>> Stashed changes
    private void moveDown()
    {
        if (canGoDown())
        {
            double currSpeed = getSpeed();
            stop();
            setRotation(getRotation() + 2);
            addForce (new Vector(getRotation(), currSpeed));
        }
    }
    
    private void warnPedestrians()
    {
        List<Crossing> crossings = getObjectsInRange(200, Crossing.class);
        List<Pedestrian> pedestriansInRange = getObjectsInRange(350, Pedestrian.class);
        if (!crossings.isEmpty())
        {
            if (!pedestriansInRange.isEmpty())
            {
                for (Crossing cr : crossings)
                {
                    if ((cr.hasTrafficLight() && cr.getTrafficLight().getState() == 1) || !cr.hasTrafficLight())
                    {
                        pedestriansInRange.forEach(Pedestrian::increaseSpeed);
                    }
                }
            }
        }
    }
    
    private void checkCollisions()
    {
        Actor pedestrian = getOneIntersectingObject(Pedestrian.class);
        Actor otherCar = getOneIntersectingObject(OtherCar.class);
        if (collidesWith(pedestrian) || collidesWith(otherCar))
        {
            Score.getInstance().reduceLevelScore(((MyWorld) getWorld()).getLevel());
            Lives.getInstance().reduceLives();
            if (Lives.getInstance().getLivesCount() > 0)
                respawn();
            else
                end(false);
        }
    }
    
    private void checkTrafficLight()
    {
        Crossing crossing = (Crossing) getOneIntersectingObject(Crossing.class);
        if (Objects.nonNull(crossing) && crossing.hasTrafficLight() && crossing.getTrafficLight().getState() == 0)
        {
            //Sound.getInstance().playWrongMove();
            if (!passed.contains(crossing))
            {
                passed.add(crossing);
                Lives.getInstance().reduceLives();
                if (Lives.getInstance().getLivesCount() < 1)
                    end(false);
            }
        }
    }
    
    private boolean checkIfStoppedBeforeCrossing()
    {
        Crossing cr = (Crossing) getOneIntersectingObject(Crossing.class);
        List<Crossing> actorsInRange = getObjectsInRange(200, Crossing.class);
        if (!actorsInRange.isEmpty() && Objects.isNull(cr))
        {
            for (Crossing crossing : actorsInRange)
            {
                if (!stopped.contains(crossing))
                {
                    stopped.add(crossing);
                    Score.getInstance().increaseLevelScore("crossings");
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean reachedEnd()
    {
        return this.getX() >= 520 ? true : false;
    }
    
    private void end(boolean success)
    {
        stop();
        if (!success)
            setImage(new GreenfootImage("explode.gif"));
        ((MyWorld) getWorld()).gameEnd(success);
    }
    
    private boolean canGoUp()
    {
        if (getY() > 140)
            return true;
        return false;
    }
    
    private boolean canGoDown()
    {
        if (getY() < 700)
            return true;
        return false;
    }
    
    private boolean collidesWith(Actor a)
    {
        if(a == null || (a != null && getX() > a.getX()))
            return false;
        return true;
    }
<<<<<<< Updated upstream
    /*
    private void twist()
    {
        Sound.getInstance().playScreech();
        for (int i=0; i<5; ++i)
        {
            setRotation(90*i);
            Greenfoot.delay(20);
            if (speed <= 0)
                setLocation(getX() - 40, getY());
            else
                setLocation(getX() + 40, getY());
        }
    } */
=======
>>>>>>> Stashed changes
    
    private void respawn()
    {
        Sound.getInstance().playBreaking();
        setLocation(getX() + 150, getY());
        for (int i=0; i<2; ++i)
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
