
import greenfoot.*;
import java.util.List;

/**
 * Write a description of class CarSelector here.
 * 
 * @author Dimitrios Zisis 
 * @version 1.0
 */
public class LanguageSelector extends Selector
{
    private String langImage;
    
    public LanguageSelector(String langImage)
    {
        this.setLangImage(langImage);
        this.setImage(new GreenfootImage(this.getLangImage() + ".png"));
    }
    /**
     * Act - do whatever the CarSelector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mousePressed(this))
        {
            deselectAll();
            select();
            Greenfoot.setWorld(new MainMenu());
        }
    }
    
    protected boolean select()
    {
        this.setLangImage(this.getLangImage() + "_selected");
        setImage(new GreenfootImage(this.getLangImage() + ".png"));
        Language.getInstance().setSelectedLanguage(getLangImage().substring(0,2));
        return true;
    }
    
    protected void deselectAll()
    {
        for (LanguageSelector cs : (List<LanguageSelector>)(getWorld().getObjects(LanguageSelector.class)))
            cs.deselect();
    }
    
    protected void deselect()
    {
        this.setLangImage(this.getLangImage().replace("_selected", ""));
        this.setImage(new GreenfootImage(this.getLangImage() + ".png"));
    }
    
    public void setLangImage(String newLangImage)
    {
        this.langImage = newLangImage;
    }
    
    public String getLangImage() 
    {
        return this.langImage;
    }
}
