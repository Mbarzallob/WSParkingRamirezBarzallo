package ec.edu.ups.ppw.WSParkingRamirezBarzallo.config;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Set;
import java.util.stream.Collectors;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        String errorMessage = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));

        Result<Void> result = Result.failure(errorMessage);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(result)
                .build();
    }
}