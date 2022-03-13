package ua.com.foxminded.formula1.provider;

import java.util.List;

import ua.com.foxminded.formula1.domain.Race;

public class RaceViewProviderImpl implements RaceViewProvider{
    private static final String LINE = "-";
    private static final String NEW_LINE = "\n";

    @Override
    public String provideView(List<Race> racers) {
        StringBuilder builder = new StringBuilder();
        
        racers.forEach(racer -> {
            if(racers.indexOf(racer) == 15) {
                int lineLength = builder.toString().split(NEW_LINE)[1].length();
                builder.append(drawLine(lineLength));
            }
            builder.append(String.format("%02d. ", racers.indexOf(racer) + 1))
            .append(String.format("%-18s|", racer.getName()))
            .append(String.format("%-26s|", racer.getTeam()))
            .append(String.format("%s", racer.getBestTime()))
            .append(String.format("%s", NEW_LINE))
            .toString();
        });
        return builder.toString();
    }
    
    private String drawLine(int value) {
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < value; i++) {
            builder.append(LINE);
        }
        builder.append(NEW_LINE);
     
        return builder.toString();
    }
}
