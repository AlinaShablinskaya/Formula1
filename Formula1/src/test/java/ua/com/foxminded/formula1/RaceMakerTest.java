package ua.com.foxminded.formula1;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ua.com.foxminded.formula1.domain.Race;
import ua.com.foxminded.formula1.provider.RaceProvider;
import ua.com.foxminded.formula1.provider.RaceViewProvider;
import ua.com.foxminded.formula1.reader.FileReader;
import ua.com.foxminded.formula1.validator.RaceValidator;


@ExtendWith(MockitoExtension.class)
class RaceMakerTest {
    
    @Mock
    private RaceProvider raceProvider;
    
    @Mock
    private RaceViewProvider raceViewProvider;
    
    @Mock
    private FileReader fileReader;
    
    @Mock
    private RaceValidator raceValidator;
    
    @InjectMocks
    private RaceMaker raceMaker;
    
    @Test
    void printResultsRaceShouldReturnResultIfGetTwoArguments() {
        
        List<Race> race = new ArrayList<>();
        
        race.add(new Race("Sebastian Vettel", "FERRARI", LocalTime.parse("00:01:04.415")));
        race.add(new Race("Daniel Ricciardo", "RED BULL RACING TAG HEUER", LocalTime.parse("00:01:12.013")));
        
        String expected = 
                "01. Sebastian Vettel  |FERRARI                   |00:01:04.415\n" + 
                "02. Daniel Ricciardo  |RED BULL RACING TAG HEUER |00:01:12.013\n";
        
        String abbreviationsTxt = "src/test/resources/abbreviations.txt";
        String startLog = "src/main/test/start.log";
        String endLog = "src/main/test/end.log";
        
        List<String> abbreviations = new ArrayList<>();
        abbreviations.add("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        abbreviations.add("SVF_Sebastian Vettel_FERRARI"); 
        
        List<String> start = new ArrayList<>();
        start.add("SVF2018-05-24_12:02:58.917");
        start.add("DRR2018-05-24_12:14:12.054");
        
        List<String> end = new ArrayList<>();
        end.add("DRR2018-05-24_12:15:24.067");
        end.add("SVF2018-05-24_12:04:03.332");
        
        when(fileReader.readFile(abbreviationsTxt)).thenReturn(abbreviations);
        when(fileReader.readFile(startLog)).thenReturn(start);
        when(fileReader.readFile(endLog)).thenReturn(end);
        when(raceProvider.provideRace(abbreviations, start, end)).thenReturn(race);
        when(raceViewProvider.provideView(race)).thenReturn(expected);
        
        String actual = raceMaker.printResultsRace(abbreviationsTxt, startLog, endLog);
        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void printResultsRaceShouldReturnIllegalArgumentExceptionIfAbbreviationsFileIsEmpty() {
        
        String expected = "File is empty";
        
        String startLog = "src/main/test/start.log";
        String endLog = "src/main/test/end.log";
        
        doThrow(new IllegalArgumentException(expected)).when(raceValidator).validate("", startLog, endLog);
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> raceMaker.printResultsRace("", startLog, endLog));
                
        String actual = exeption.getMessage();
        
        assertThat(expected, is(equalTo(actual)));
    }
}
