
import greenfoot.*;
import java.util.List;

/**
 * Write a description of class CarSelector here.
 * 
 * @author Dimitrios Zisis 
 * @version 1.0
 */
public class CarSelector extends Actor
{
    private String carImage;
    
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
    
    public boolean select()
    {
        this.setCarImage(this.getCarImage() + "_selected");
        setImage(new GreenfootImage(this.getCarImage() + ".png"));
        if (this.getCarImage().contains("Car_2"))
            this.getImage().rotate(180);
        Settings.getInstance().setSelectedCar(this.getCarImage());
        return true;
    }
    
    private void deselectAll()
    {
        for (CarSelector cs : (List<CarSelector>)(getWorld().getObjects(CarSelector.class)))
            cs.deselect();
    }
    
    public void deselect()
    {
        this.setCarImage(this.getCarImage().replace("_selected", ""));
        this.setImage(new GreenfootImage(this.getCarImage() + ".png"));
        if (this.getCarImage().contains("Car_2"))
            this.getImage().rotate(180);
    }
    
    public void setCarImage(String newCarImage)
    {
        this.carImage = newCarImage;
    }
    
    public String getCarImage() 
    {
        return this.carImage;
    }
}
