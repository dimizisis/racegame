import greenfoot.*;

/**
 * Class that represents the explanatory GIF image,
 * whose instances are contained to every instance
 * of InformationWindow class.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class ExplanatoryGIF extends Actor
{
    private GifImage explanatoryGIF;
    private String type;
    
    /**
     * Constructor for objects of class ExplanatoryGIF.
     * @param type  the type of explanatory GIF image (crossing, stop sign, etc)
     */
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
