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
<<<<<<< Updated upstream
    private String currLang;
=======
    private String selectedLang;
>>>>>>> Stashed changes

    /**
     * Constructor for objects of class Language
     */
    private Language()
    {
<<<<<<< Updated upstream
        this.currLang = "gr";
=======
        this.selectedLang = "gr";
>>>>>>> Stashed changes
    }
    
    public static Language getInstance() 
    {
        if (Objects.isNull(langInstance))
            langInstance = new Language();
  
        return langInstance;
    }
    
<<<<<<< Updated upstream
    public String getCurrLanguage()
    {
        return this.currLang;
=======
    public String getSelectedLanguage()
    {
        return this.selectedLang;
    }
    
    public void setSelectedLanguage(String sl)
    {
        this.selectedLang = sl;
>>>>>>> Stashed changes
    }
    
    public String changeLanguage()
    {
<<<<<<< Updated upstream
        if (getCurrLanguage().equals("gr"))
            this.currLang = "en";
        else
            this.currLang = "gr";
        return this.currLang;
=======
        if (getSelectedLanguage().equals("gr"))
            this.selectedLang = "en";
        else
            this.selectedLang = "gr";
        return this.selectedLang;
>>>>>>> Stashed changes
    }
}
