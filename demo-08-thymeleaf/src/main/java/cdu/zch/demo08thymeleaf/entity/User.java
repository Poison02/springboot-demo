package cdu.zch.demo08thymeleaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zch
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;

    private String password;

}
