package ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.Set;

public class ValidationUtils {

    public static <T> void validate(T object, Validator validator) throws Exception{
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            String errorMessage = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .reduce((msg1, msg2) -> msg1 + ", " + msg2)
                    .orElse("Validation failed");
            throw new Exception(errorMessage);
        }
    }
}