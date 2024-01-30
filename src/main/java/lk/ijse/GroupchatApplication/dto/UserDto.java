package lk.ijse.GroupchatApplication.dto;

import lombok.*;

import java.io.InputStream;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String employeeId;
    private String username;
    private InputStream image;
}
