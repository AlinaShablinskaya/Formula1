package ua.com.foxminded.formula1.provider;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalTime;

import ua.com.foxminded.formula1.domain.Race;

public class RaceProviderImpl implements RaceProvider{
    
    private static final String DELIMITER = "_";

    @Override
    public List<Race> provideRace(List<String> abbreviations, List<String> start, List<String> end) {
        
        Map<String, String> nameAndTeamAbbreviations = putAbbreviations(abbreviations);
        Map<String, String> mapStart = putTime(start);
        Map<String, String> mapEnd = putTime(end);
        
        List<String> racerAbbreviation = new ArrayList<>(nameAndTeamAbbreviations.keySet());
        Map<String, String> consolidated = new HashMap<>(nameAndTeamAbbreviations);
        mapStart.forEach(consolidated::put);
        mapEnd.forEach(consolidated::put);
        
        List<Race> race = new ArrayList<>();
        
        for(int i = 0; i < abbreviations.size(); i++) {
            String abbreviation = racerAbbreviation.get(i);
            String name = nameAndTeamAbbreviations.get(abbreviation).split(DELIMITER)[0];
            String team = nameAndTeamAbbreviations.get(abbreviation).split(DELIMITER)[1];
            LocalTime startTime = LocalTime.parse(mapStart.get(abbreviation));
            LocalTime endTime = LocalTime.parse(mapEnd.get(abbreviation));
            LocalTime bestTime = timing(startTime, endTime);
            race.add(new Race(name, team, bestTime));
        }       
        return race.stream().sorted(Comparator.comparing(Race::getBestTime))
                .collect(Collectors.toList());
    }
    
    private Map<String, String> putAbbreviations(List<String> abbreviations) {
        return abbreviations.stream().map(s -> s.split(DELIMITER))
                .collect(Collectors.toMap(a -> a[0], a1 -> a1[1].concat(DELIMITER).concat(a1[2])));          
    }
    
    private Map<String, String> putTime(List<String> time) {
        return time.stream().map(s -> s.split(DELIMITER))
                .collect(Collectors.toMap(a -> a[0].substring(0, 3), a1 -> a1[1]));
    } 
    
    private LocalTime timing(LocalTime start, LocalTime finish) {
        return finish.minusNanos(start.toNanoOfDay());
    }
}
