package org.unlogged.demo.models.valid;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserV2 {

    @Min(value = 1, message = "Value needs to be 1 or more")
    @Max(value = 100, message = "Value can't exceed 100")
    private Long id;

    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Name can't be null")
    @Email(message = "Email needs to be valid")
    private String email;

    @NotNull(message = "Phone number can't be null")
    @NotNull(message = "Phone number can't be null")
    private String phoneNumber;
}
