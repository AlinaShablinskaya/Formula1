package ua.com.foxminded.formula1.provider;

import java.util.List;

import ua.com.foxminded.formula1.domain.Race;

public interface RaceProvider {
    List<Race> provideRace(List<String> abbreviations, List<String> start, List<String> end);
}
