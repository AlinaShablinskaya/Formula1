package ua.com.foxminded.formula1;

import java.util.List;

import ua.com.foxminded.formula1.domain.Race;
import ua.com.foxminded.formula1.provider.RaceViewProvider;
import ua.com.foxminded.formula1.validator.RaceValidator;
import ua.com.foxminded.formula1.provider.RaceProvider;
import ua.com.foxminded.formula1.reader.FileReader;

public class RaceMaker {
    
    private final RaceValidator raceValidator;
    private final RaceViewProvider raceViewProvider;
    private final RaceProvider raceProvider;
    private final FileReader fileReader;
    
    public RaceMaker(RaceValidator raceValidator, RaceViewProvider raceViewProvider, RaceProvider raceProvider,
            FileReader fileReader) {
        this.raceValidator = raceValidator;
        this.raceViewProvider = raceViewProvider;
        this.raceProvider = raceProvider;
        this.fileReader = fileReader;
    }
    
    public String printResultsRace (String abbreviationFile, String startFile, String endFile) {
        raceValidator.validate(abbreviationFile, startFile, endFile);
        
        List<String> abbreviations = fileReader.readFile(abbreviationFile);
        List<String> start = fileReader.readFile(startFile);
        List<String> end = fileReader.readFile(endFile);
        
        List<Race> race = raceProvider.provideRace(abbreviations, start, end);
        return raceViewProvider.provideView(race); 
    }
}
