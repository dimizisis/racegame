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
    private String selectedLang;

    /**
     * Constructor for objects of class Language
     */
    private Language()
    {
        this.selectedLang = "gr";
    }
    
    public static Language getInstance() 
    {
        if (Objects.isNull(langInstance))
            langInstance = new Language();
  
        return langInstance;
    }
    
    public String getSelectedLanguage()
    {
        return this.selectedLang;
    }
    
    public void setSelectedLanguage(String sl)
    {
        this.selectedLang = sl;
    }
    
    public String changeLanguage()
    {
        if (getSelectedLanguage().equals("gr"))
            this.selectedLang = "en";
        else
            this.selectedLang = "gr";
        return this.selectedLang;
    }
}
