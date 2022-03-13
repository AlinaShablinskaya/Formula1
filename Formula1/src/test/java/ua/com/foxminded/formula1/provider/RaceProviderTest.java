package ua.com.foxminded.formula1.provider;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.formula1.domain.Race;

class RaceProviderTest {
    
    private final RaceProvider raceProvider = new RaceProviderImpl();

    @Test
    void provideRaceShouldReturnResultIfGetAllArguments() {
        List<Race> expected = new ArrayList<>();
        
        expected.add(new Race("Sebastian Vettel", "FERRARI", LocalTime.parse("00:01:04.415")));
        expected.add(new Race("Daniel Ricciardo", "RED BULL RACING TAG HEUER", LocalTime.parse("00:01:12.013")));
        
        
        List<String> abbreviations = Arrays.asList("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER", "SVF_Sebastian Vettel_FERRARI");
        List<String> start = Arrays.asList("SVF2018-05-24_12:02:58.917", "DRR2018-05-24_12:14:12.054");
        List<String> end = Arrays.asList("DRR2018-05-24_12:15:24.067", "SVF2018-05-24_12:04:03.332");
        
        List<Race> actual = raceProvider.provideRace(abbreviations, start, end);
        
        assertThat(actual, is(equalTo(expected)));        
    }
}
