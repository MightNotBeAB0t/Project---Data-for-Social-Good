public class CountryStats {

    private String countries; // country name
    private int casualties;   // number of casualties

    // constructor to set country name and casualties
    public CountryStats(String countries, int casualties) {
        this.countries = countries;
        this.casualties = casualties;
    }

    // getter for country name
    public String getCountries() {
        return countries;
    }

    // getter for casualty count
    public int getCasualties() {
        return casualties;
    }

    // returns a simple string representation of the object
    public String toString() {
        return "Country: " + countries + "\nCasualites: " + casualties;
    }
}

/*
declaring the stuff
get methods
constructor and toString

giving values to the variable
*/
