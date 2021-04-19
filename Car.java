
    import greenfoot.*;
    import java.util.Objects;
    /**
     * Write a description of class Car here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Car extends Actor
    {
        private int speed = 1;
        private final static int SPEED_LIMIT = 2;
        /**
         * Act - do whatever the Car wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            move(speed);
            Actor cone = getOneIntersectingObject(Cone.class);
            Crossing crossing = (Crossing) getOneIntersectingObject(Crossing.class);
            
            if (Greenfoot.isKeyDown("h"))
                Greenfoot.playSound("horn.wav");
                
            if (isTouching(Oil.class))
                twist();
                
            if (collides(cone))
                respawn();
        
            if (Objects.nonNull(crossing) && crossing.hasTrafficLight() && crossing.getTrafficLight().getState() == 0)
                Greenfoot.playSound("wrong-move.wav");
        
            if (Greenfoot.isKeyDown("up"))
            {
                if (canGoUp())
                    setLocation(getX(), getY() - 2);
            }
            if (Greenfoot.isKeyDown("down"))
            {
                if (canGoDown())
                    setLocation(getX(), getY() + 2);
            }
            if (Greenfoot.isKeyDown("right"))
            {
                if (speed >= 0)
                {
                    ++speed;   
                    if (speed > SPEED_LIMIT) speed = SPEED_LIMIT;
                }
                if (speed <= 0)
                    speed = 0;
            }
        
            if (Greenfoot.isKeyDown("left"))
            {
                if (speed > 1)
                    --speed;
                if (speed == 0)
                {
                    --speed;
                    if (Math.abs(speed) >= SPEED_LIMIT) speed = -SPEED_LIMIT;
                }
            }
        
            if (Greenfoot.isKeyDown("b"))
            {
                speed = 0;
            }
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
    
    private boolean collides(Actor a)
    {
        if(a == null || (a != null && getX() > a.getX()))
            return false;
        return true;
    }
    
    private void twist()
    {
        speed = 0;
        Greenfoot.playSound("screech.mp3");
        for (int i=0; i<5; ++i)
        {
            setRotation(90*i);
            Greenfoot.delay(50);
            setLocation(getX() + 30, getY());
        }
    }
    
    private void respawn()
    {
        Greenfoot.playSound("break.wav");
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
