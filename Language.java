import java.util.Objects;

/**
 * Class that holds the game's language data.
 * It is created using the Singleton Pattern.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Language  
{
    private static Language langInstance = null;
    private String selectedLang;

    /**
     * Constructor for object of class Language.
     * Cannot be called outside the instance.
     */
    private Language()
    {
        this.selectedLang = "gr"; /* Greek by default */
    }
    
    /**
     * Returns the (only) instance of class Language.
     * 
     * @return  the instance of class Language
     */
    public static Language getInstance() 
    {
        if (Objects.isNull(langInstance))
            langInstance = new Language();
  
        return langInstance;
    }
    
    /**
     * Returns the current selected language of the game.
     * 
     * @return  the string representation of the language (either "en" or "gr")
     */
    public String getSelectedLanguage()
    {
        return this.selectedLang;
    }
    
    /**
     * Sets the current selected language of the game.
     * 
     * @param  the string representation of the language (either "en" or "gr")
     */
    public void setSelectedLanguage(String sl)
    {
        this.selectedLang = sl;
    }
    
    /**
     * Toggles the current selected language of the game.
     * 
     * @return  the string representation of the toggled language (either "en" or "gr")
     */
    public String changeLanguage()
    {
        if (getSelectedLanguage().equals("gr"))
            this.selectedLang = "en";
        else
            this.selectedLang = "gr";
        return this.selectedLang;
    }
}
