package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.Size;

public class AuthenticationDto {
    @Size(min = 4, message = "The name should be higher than 4")
    private String username;
    @Size(min = 4, message = "The password should be higher than 4")
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
