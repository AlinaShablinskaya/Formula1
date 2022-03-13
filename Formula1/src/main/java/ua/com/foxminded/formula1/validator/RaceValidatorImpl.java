package ua.com.foxminded.formula1.validator;

public class RaceValidatorImpl implements RaceValidator {

    @Override
    public void validate(String abbreviationFile, String startFile, String endFile) {

        if (abbreviationFile.isEmpty() || startFile.isEmpty() || endFile.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }
    }
}
