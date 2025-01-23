// Date: 1/23/25
// Name: Everett
// Description: Defines the country class that is referenced in the main.java file. Every country has a couple attributes to make the quizzing part a little easier complexity wise.

public class Country
{

  private String countryName="";
  private String cap="";
  private String language="";
  private String imageFile="";


  public Country(String countryName, String cap, String language, String imageFile) 
  {
    this.countryName = countryName;
    this.cap = cap;
    this.language = language;
    this.imageFile = imageFile;
  }

  public Country() {
    countryName = "United States";
    cap = "Washington D.C.";
    language = "English";
    imageFile = "US.jpg";
  }

  
  public String getImageFile() {
    return imageFile;
  }
  
  public String getLanguage() {
    return language;
  }
  public String toString() {

    return countryName+"'s capital is " + cap + " and its primary language is " + language;
  }


  public String getName() {
    return countryName;
  }

  public String getCapital() {
    return cap;
  }
  
}