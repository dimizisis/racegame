
    import greenfoot.*;
    import java.util.Objects;
    /**
     * Write a description of class Car here.
     * 
     * @author Dimitrios Zisis 
     * @version 1.0
     */
    public class Car extends Actor
    {
        private boolean broke = false;
        private int speed = 1;
        private final static int SPEED_LIMIT = 10;
        /**
         * Act - do whatever the Car wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            move(speed);
            Actor cone = getOneIntersectingObject(Cone.class);
            Actor pedestrian = getOneIntersectingObject(Pedestrian.class);
            Crossing crossing = (Crossing) getOneIntersectingObject(Crossing.class);
            
            if (Greenfoot.isKeyDown("h"))
                Sound.getInstance().playHorn();
                
            if (isTouching(Oil.class))
                twist();
                
            if (collidesWith(cone) || collidesWith(pedestrian))
            {
                if (Lives.getInstance().reduceLives() > 0 && !this.broke)
                    respawn();
                else
                {
                    end();
                }
            }
        
            if (Objects.nonNull(crossing) && crossing.hasTrafficLight() && crossing.getTrafficLight().getState() == 0)
                Sound.getInstance().playWrongMove();
        
            if (Greenfoot.isKeyDown("up"))
                goUp();
            
            if (Greenfoot.isKeyDown("down"))
                goDown();
            
            if (Greenfoot.isKeyDown("right"))
                accelerate();
        
            if (Greenfoot.isKeyDown("left"))
                reverse();
        
            if (Greenfoot.isKeyDown("b"))
                stop();
    }
    
    private void end()
    {
        this.broke = true;
        stop();
        setImage(new GreenfootImage("explode.gif"));
        ((MyWorld) getWorld()).gameOver();
    }
    
    private void goUp()
    {
       if (canGoUp())
            setLocation(getX(), getY() - 2); 
    }
    
    private void goDown()
    {
        if (canGoDown())
            setLocation(getX(), getY() + 2);
    }
    
    private void stop()
    {
        speed = 0;
    }
    
    private void reverse()
    {
        if (speed > 1)
            --speed;
        if (speed == 0)
        {
            --speed;
            if (Math.abs(speed) >= SPEED_LIMIT) speed = -SPEED_LIMIT;
        }
    }
    
    private void accelerate()
    {
        if (speed >= 0)
        {
            ++speed;   
            if (speed > SPEED_LIMIT) speed = SPEED_LIMIT;
        }
        if (speed <= 0)
            speed = 0;
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
    
    private void twist()
    {
        Sound.getInstance().playScreech();
        for (int i=0; i<5; ++i)
        {
            setRotation(90*i);
            Greenfoot.delay(50);
            if (speed <= 0)
                setLocation(getX() - 30, getY());
            else
                setLocation(getX() + 30, getY());
        }
    }
    
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
