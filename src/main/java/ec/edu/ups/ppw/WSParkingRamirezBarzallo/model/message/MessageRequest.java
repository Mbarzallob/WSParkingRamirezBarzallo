package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.message;

import jakarta.validation.constraints.NotBlank;

public class MessageRequest {

    @NotBlank
    private String message;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
