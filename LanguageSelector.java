import greenfoot.*;
import java.util.List;

/**
 * Class that represents a LanguageSelector,
 * used to choose between languages.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class LanguageSelector extends Selector
{
    private String langImage;
    
    /**
     * Constructor for objects of class LanguageSelector.
     * @param langImage  the string representation of a language image name.
     */
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
    
    /**
     * Selects a language, when its image is clicked.
     */
    protected void select()
    {
        this.setLangImage(this.getLangImage() + "_selected");
        setImage(new GreenfootImage(this.getLangImage() + ".png"));
        Language.getInstance().setSelectedLanguage(getLangImage().substring(0,2));
    }
    
    /**
     * Deselects all language images.
     * Triggered when a language image is selected.
     */
    protected void deselectAll()
    {
        for (LanguageSelector cs : (List<LanguageSelector>)(getWorld().getObjects(LanguageSelector.class)))
            cs.deselect();
    }
    
    /**
     * Deselects a language image.
     * Invoked only by deselectAll method.
     */
    protected void deselect()
    {
        this.setLangImage(this.getLangImage().replace("_selected", ""));
        this.setImage(new GreenfootImage(this.getLangImage() + ".png"));
    }
    
    /**
     * Language image setter
     * @param newLangImage  the new language image that will be set.
     */
    public void setLangImage(String newLangImage)
    {
        this.langImage = newLangImage;
    }
    
    /**
     * Language image getter.
     * @return  the string representation of a language image name.
     */
    public String getLangImage() 
    {
        return this.langImage;
    }
}
