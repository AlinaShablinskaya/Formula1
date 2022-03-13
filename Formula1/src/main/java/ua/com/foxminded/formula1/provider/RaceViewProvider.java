package ua.com.foxminded.formula1.provider;

import java.util.List;

import ua.com.foxminded.formula1.domain.Race;

public interface RaceViewProvider {
    String provideView(List<Race> race);
}
