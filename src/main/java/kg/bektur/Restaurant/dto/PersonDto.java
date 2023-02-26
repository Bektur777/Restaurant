package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class PersonDto extends AbstractDto {
    private Long id;
    @NotEmpty(message = "The username shouldn't be empty")
    private String username;
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message = "The full name should be like 'Joe Joe Joe'")
    private String fullName;
    @NotEmpty(message = "The address shouldn't be empty")
    private String address;
    @NotEmpty(message = "The email shouldn't be empty")
    @Email(message = "The email should be valid")
    private String email;
    @NotEmpty(message = "The number shouldn't be empty")
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
