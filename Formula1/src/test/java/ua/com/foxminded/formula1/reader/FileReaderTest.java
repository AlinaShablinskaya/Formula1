package ua.com.foxminded.formula1.reader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FileReaderTest {
    
    private final FileReader fileReader = new FileReaderImpl();

    @Test
    void readFileShouldReturnResultIfGetFilePath() {
        String expected = "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER";
        String path = "src/test/resources/abbreviations.txt";
        
        String actual = fileReader.readFile(path).get(0);
        
        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void readFileShouldThrowIllegalArgumentExceptionIfGetWrongFilePath() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> fileReader.readFile(""));
        
        String expected = "File does not exist";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
}
