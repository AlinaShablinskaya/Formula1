package ua.com.foxminded.formula1.provider;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.formula1.domain.Race;

class ViewProviderTest {
    
    private final RaceViewProvider raceViewProvider = new RaceViewProviderImpl();

    @Test
    void provideViewShouldReturnResultIfGetAllArguments() {
        
        List<Race> race = new ArrayList<>();
        race.add(new Race("Sebastian Vettel", "FERRARI", LocalTime.parse("00:01:04.415")));
        race.add(new Race("Daniel Ricciardo", "RED BULL RACING TAG HEUER", LocalTime.parse("00:01:12.013")));
        race.add(new Race("Valtteri Bottas", "MERCEDES", LocalTime.parse("00:01:12.434")));
        race.add(new Race("Lewis Hamilton", "MERCEDES", LocalTime.parse("00:01:12.460")));
        race.add(new Race("Stoffel Vandoorne", "MCLAREN RENAULT", LocalTime.parse("00:01:12.463")));
        race.add(new Race("Kimi Raikkonen", "FERRARI", LocalTime.parse("00:01:12.639")));
        race.add(new Race("Fernando Alonso", "MCLAREN RENAULT", LocalTime.parse("00:01:12.657")));
        race.add(new Race("Sergey Sirotkin", "WILLIAMS MERCEDES", LocalTime.parse("00:01:12.706")));
        race.add(new Race("Charles Leclerc", "SAUBER FERRARI", LocalTime.parse("00:01:12.829")));
        race.add(new Race("Sergio Perez", "FORCE INDIA MERCEDES", LocalTime.parse("00:01:12.848")));
        race.add(new Race("Romain Grosjean", "HAAS FERRARI", LocalTime.parse("00:01:12.930")));
        race.add(new Race("Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", LocalTime.parse("00:01:12.941")));
        race.add(new Race("Carlos Sainz", "RENAULT", LocalTime.parse("00:01:12.950")));
        race.add(new Race("Esteban Ocon", "FORCE INDIA MERCEDES", LocalTime.parse("00:01:13.028")));
        race.add(new Race("Nico Hulkenberg", "RENAULT", LocalTime.parse("00:01:13.065")));
        race.add(new Race("Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", LocalTime.parse("00:01:13.179")));
        race.add(new Race("Marcus Ericsson", "SAUBER FERRARI", LocalTime.parse("00:01:13.265")));
        race.add(new Race("Lance Stroll", "WILLIAMS MERCEDES", LocalTime.parse("00:01:13.323")));
        race.add(new Race("Kevin Magnussen", "HAAS FERRARI", LocalTime.parse("00:01:13.393")));
        
        String expected = 
                "01. Sebastian Vettel  |FERRARI                   |00:01:04.415\n" + 
                "02. Daniel Ricciardo  |RED BULL RACING TAG HEUER |00:01:12.013\n" + 
                "03. Valtteri Bottas   |MERCEDES                  |00:01:12.434\n" +
                "04. Lewis Hamilton    |MERCEDES                  |00:01:12.460\n" +
                "05. Stoffel Vandoorne |MCLAREN RENAULT           |00:01:12.463\n" +
                "06. Kimi Raikkonen    |FERRARI                   |00:01:12.639\n" +
                "07. Fernando Alonso   |MCLAREN RENAULT           |00:01:12.657\n" +
                "08. Sergey Sirotkin   |WILLIAMS MERCEDES         |00:01:12.706\n" +
                "09. Charles Leclerc   |SAUBER FERRARI            |00:01:12.829\n" +
                "10. Sergio Perez      |FORCE INDIA MERCEDES      |00:01:12.848\n" +
                "11. Romain Grosjean   |HAAS FERRARI              |00:01:12.930\n" +
                "12. Pierre Gasly      |SCUDERIA TORO ROSSO HONDA |00:01:12.941\n" +
                "13. Carlos Sainz      |RENAULT                   |00:01:12.950\n" +
                "14. Esteban Ocon      |FORCE INDIA MERCEDES      |00:01:13.028\n" +
                "15. Nico Hulkenberg   |RENAULT                   |00:01:13.065\n" +
                "--------------------------------------------------------------\n" +
                "16. Brendon Hartley   |SCUDERIA TORO ROSSO HONDA |00:01:13.179\n" +
                "17. Marcus Ericsson   |SAUBER FERRARI            |00:01:13.265\n" +
                "18. Lance Stroll      |WILLIAMS MERCEDES         |00:01:13.323\n" +
                "19. Kevin Magnussen   |HAAS FERRARI              |00:01:13.393\n";
        
        String actual = raceViewProvider.provideView(race);
        
        assertThat(expected, is(equalTo(actual)));
    }
}
