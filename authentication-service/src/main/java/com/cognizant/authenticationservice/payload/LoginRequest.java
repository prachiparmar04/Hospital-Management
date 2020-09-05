package com.cognizant.authenticationservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author POD 13
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
}
