package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;

import java.time.LocalDate;

public class UserDTO {
    private int id;
    private String username;
    private int status;
    private int role;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getPerson().getEmail());
        userDTO.setPhone(user.getPerson().getPhoneNumber());
        userDTO.setCreationDate(user.getCreationDate());
        userDTO.setRole(user.getRole().getId());
        userDTO.setFirstName(user.getPerson().getFirstName());
        userDTO.setLastName(user.getPerson().getLastName());
        userDTO.setRole(user.getRole().getId());
        userDTO.setGender(user.getPerson().getGender().getId());
        userDTO.setBirthDate(user.getPerson().getBirthDate());
        return userDTO;
    }
}
