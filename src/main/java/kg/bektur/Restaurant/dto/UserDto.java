package kg.bektur.Restaurant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto extends AbstractDto {
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

}
