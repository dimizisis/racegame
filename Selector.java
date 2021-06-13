import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Selector extends Actor
{
    /**
     * Act - do whatever the Selector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public abstract void act();   
    protected abstract boolean select();
    protected abstract void deselectAll();
    protected abstract void deselect();
}
