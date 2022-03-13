package ua.com.foxminded.formula1.validator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class RaceValidatorTest {
    
    private final RaceValidator raceValidator = new RaceValidatorImpl();
    private final String abbreviations = "src/test/resources/abbreviations.txt";
    private final String start = "src/test/resources/start.log";
    private final String end = "src/test/resources/end.log";

    @Test
    void validateShouldReturnIllegalArgumentExceptionIfAbbreviationsFileIsEmpty() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> raceValidator.validate("", start, end));
        
        String expected = "File is empty";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateShouldReturnIllegalArgumentExceptionIfStartFileIsEmpty() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> raceValidator.validate(abbreviations, "", end));
        
        String expected = "File is empty";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateShouldReturnIllegalArgumentExceptionIfEndFileIsEmpty() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> raceValidator.validate(abbreviations, start, ""));
        
        String expected = "File is empty";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateShouldNotReturnException() {
        
        assertDoesNotThrow(() -> raceValidator.validate(abbreviations, start, end));   
    }
}
