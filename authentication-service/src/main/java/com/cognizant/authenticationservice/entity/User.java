package com.cognizant.authenticationservice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author POD 13
 *
 */
@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class User {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 
     */
    @NonNull
    @Size(min=4,max=14,message="Username must contain 4-14 Characters!")
    private String username;
    /**
     * 
     */
    @NonNull
    @Size(min=5,max=15,message="Password must contain 5-15 Characters!")
    private String password;
    /**
     * 
     */
    @NonNull
    private String roles;
}
