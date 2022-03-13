package ua.com.foxminded.formula1.reader;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderImpl implements FileReader{

    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException exeption) {
            throw new IllegalArgumentException("File does not exist");
        }
    } 
}
