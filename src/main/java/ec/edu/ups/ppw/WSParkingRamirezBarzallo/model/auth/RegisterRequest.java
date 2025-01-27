package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;


public class RegisterRequest {

    private String email;
    @NotBlank(message = "Tiene que tener un usuario valido")
    private String username;
    @NotBlank(message = "Tiene que tener una contraseña")
    private String password;
    @NotBlank(message = "Debe ingresar su primer nombre")
    private String firstName;
    @NotBlank(message = "Debe ingresar su apellido")
    private String lastName;
    @NotBlank(message = "Debe ingresar una identificacion")
    private String identification;
    private String phone;
    private int genderId;
    public String getIdentification() {
        return identification;
    }

    public void setIdentification( String identification) {
        this.identification = identification;
    }



    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private LocalDate dateOfBirth;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }


}
