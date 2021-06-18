import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplanatoryGIF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplanatoryGIF extends Actor
{
    GifImage explanatoryGIF;
    private String type;
    
    public ExplanatoryGIF(String type)
    {
        this.type = type;
        this.explanatoryGIF = new GifImage(type + "_explained.gif");
    }
    /**
     * Act - do whatever the ExplanatoryGIF wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(explanatoryGIF.getCurrentImage());
    }
}
