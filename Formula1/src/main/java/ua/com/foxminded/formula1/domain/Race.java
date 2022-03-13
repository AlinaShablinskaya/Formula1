package ua.com.foxminded.formula1.domain;

import java.time.LocalTime;
import java.util.Objects;

public class Race {
    private final String name;
    private final String team;
    private final LocalTime bestTime;
    
    public Race(String name, String car, LocalTime bestTime) {
        this.name = name;
        this.team = car;
        this.bestTime = bestTime;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public LocalTime getBestTime() {
        return bestTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team, bestTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Race other = (Race) obj;
        return Objects.equals(name, other.name) &&
               Objects.equals(team, other.team) &&
               Objects.equals(bestTime, other.bestTime);
    }

    @Override
    public String toString() {
        return "Racer [name=" + name + ", car=" + team + ", bestTime=" + bestTime + "]";
    }
}
