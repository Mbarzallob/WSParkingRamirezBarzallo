package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Tiene que ingresar un usuario")
    private String username;
    @NotBlank(message = "Tiene que ingresar una contraseña")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
