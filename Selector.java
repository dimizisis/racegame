import greenfoot.*;

/**
 * Abstract class that represents a selector,
 * mainly used for Language selector and car
 * selector in this version of the game.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public abstract class Selector extends Actor
{
    public abstract void act();   
    protected abstract void select();
    protected abstract void deselectAll();
    protected abstract void deselect();
}
