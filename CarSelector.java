import greenfoot.*;
import java.util.List;

/**
 * Class that represents a CarSelector,
 * used to choose among cars in SettingsMenu.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class CarSelector extends Selector
{
    private String carImage;
    
    /**
     * Constructor for objects of class CarSelector.
     * @param carImage  the string representation of each car's image
     */
    public CarSelector(String carImage)
    {
        this.setCarImage(carImage);
        this.setImage(new GreenfootImage(this.getCarImage() + ".png"));
        if (this.getCarImage().contains("Car_2"))
            this.getImage().rotate(180);
    }
    /**
     * Act - do whatever the CarSelector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Settings.getInstance().getCarAvailability().get(this.getCarImage().replace("_disabled", "").replace("_selected", "")))
        {
            if (Greenfoot.mousePressed(this))
            {
                deselectAll();
                select();
            }
        }
    }
    
    /**
     * Selects a car, when its image is clicked.
     */
    protected void select()
    {
        this.setCarImage(this.getCarImage() + "_selected");
        setImage(new GreenfootImage(this.getCarImage() + ".png"));
        if (this.getCarImage().contains("Car_2"))
            this.getImage().rotate(180);
        Settings.getInstance().setSelectedCar(this.getCarImage());
    }
    
    /**
     * Deselects all car images.
     * Triggered when a car image is selected.
     */
    protected void deselectAll()
    {
        for (CarSelector cs : (List<CarSelector>)(getWorld().getObjects(CarSelector.class)))
            cs.deselect();
    }
    
    /**
     * Deselects a car image.
     * Invoked only by deselectAll method.
     */
    protected void deselect()
    {
        this.setCarImage(this.getCarImage().replace("_selected", ""));
        this.setImage(new GreenfootImage(this.getCarImage() + ".png"));
        if (this.getCarImage().contains("Car_2"))
            this.getImage().rotate(180);
    }
    
    /**
     * Car image setter
     * @param newCarImage  the new car image that will be set.
     */
    public void setCarImage(String newCarImage)
    {
        this.carImage = newCarImage;
    }
    
    /**
     * Car image getter.
     * @return  the string representation of a car image name.
     */
    public String getCarImage() 
    {
        return this.carImage;
    }
}
