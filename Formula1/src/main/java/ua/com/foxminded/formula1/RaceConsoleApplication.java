package ua.com.foxminded.formula1;

import ua.com.foxminded.formula1.provider.RaceProvider;
import ua.com.foxminded.formula1.provider.RaceProviderImpl;
import ua.com.foxminded.formula1.provider.RaceViewProvider;
import ua.com.foxminded.formula1.provider.RaceViewProviderImpl;
import ua.com.foxminded.formula1.reader.FileReader;
import ua.com.foxminded.formula1.reader.FileReaderImpl;
import ua.com.foxminded.formula1.validator.RaceValidator;
import ua.com.foxminded.formula1.validator.RaceValidatorImpl;

public class RaceConsoleApplication {
    public static void main( String[] args ) {
        String abbreviationsTxt = "src/main/resources/abbreviations.txt";
        String startLog = "src/main/resources/start.log";
        String endLog = "src/main/resources/end.log";
        
        RaceProvider raceProvider = new RaceProviderImpl();
        RaceViewProvider raceViewProvider = new RaceViewProviderImpl();
        FileReader fileReader = new FileReaderImpl();
        RaceValidator raceValidator = new RaceValidatorImpl();
        
        
        RaceMaker raceMaker = new RaceMaker(raceValidator, raceViewProvider, raceProvider, fileReader);
        String result = raceMaker.printResultsRace(abbreviationsTxt, startLog, endLog);
        System.out.println(result);
    }
}
