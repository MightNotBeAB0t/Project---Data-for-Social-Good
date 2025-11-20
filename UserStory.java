public class UserStory {

    private CountryStats[] stats; // holds stats for each country

    public UserStory(String countryFile, String casualtyFile) {
        this.stats = createCountries(countryFile, casualtyFile); // initialize stats from files
    }

    public CountryStats[] createCountries(String countryFile, String casualtyFile) {
        String[] countries = FileReader.toStringArray(countryFile); // read country names
        int[] casualties = FileReader.toIntArray(casualtyFile); // read casualty numbers

        CountryStats[] statsArray = new CountryStats[countries.length];

        for (int i = 0; i < countries.length; i++) {
            statsArray[i] = new CountryStats(countries[i], casualties[i]); // create stats objects
        }

        return statsArray;
    }

    public String getCountryWithMostCasualties() {
        int max = 0; // index of country with max casualties

        for (int i = 1; i < stats.length; i++) {
            if (stats[i].getCasualties() > stats[max].getCasualties()) {
                max = i;
            }
        }

        return stats[max].getCountries() +", which had " + stats[max].getCasualties() + " casualties";
    }

    public int getAverageCasualties() {
        int total = 0;
        for (int i = 0; i < stats.length; i++) {
            total += stats[i].getCasualties(); // sum casualties
        }
        return total / stats.length; // return average
    }

    public int getAboveMillion() {
        int totalAbove = 0;

        for (int i = 0; i < stats.length; i++) {
            if (stats[i].getCasualties() >= 1_000_000) {
                totalAbove++; // count countries above 1 million
            }
        }

        return totalAbove;
    }
    //The Questions
    public String toString() {
      String result = 
       "As world history enjoyers, we want to analyze casualties by country during WW2, so that we can understand the scale of human cost during the war\n" + 
       "Question 1: Which country suffered the most casualties?\n"+
       "Question 2: What is the average number of casualties across all countries?\n" + 
       "Question 3: How many countries had casualties above 1,000,000?";

      //The results
      result+= "\n\nCasualty Summary: \n";
      result += "Total number of countries: " + stats.length + "\n";
      result += "Country with the most casualties: " + getCountryWithMostCasualties() + "\n";
      result += "Average number of casualties per country in the world: " + getAverageCasualties() + "\n";
      result += "Number of countries with over one million casualties: " + getAboveMillion() + "\n";
      return result;
    }
}
