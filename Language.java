import java.util.Objects;
/**
 * Write a description of class Language here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Language  
{

    private static Language langInstance = null;
    private String currLang;

    /**
     * Constructor for objects of class Language
     */
    private Language()
    {
        this.currLang = "gr";
    }
    
    public static Language getInstance() 
    {
        if (Objects.isNull(langInstance))
            langInstance = new Language();
  
        return langInstance;
    }
    
    public String getCurrLanguage()
    {
        return this.currLang;
    }
    
    public String changeLanguage()
    {
        if (getCurrLanguage().equals("gr"))
            this.currLang = "en";
        else
            this.currLang = "gr";
        return this.currLang;
    }
}
