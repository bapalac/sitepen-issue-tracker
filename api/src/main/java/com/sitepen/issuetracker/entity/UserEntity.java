package com.sitepen.issuetracker.entity;

import com.sitepen.issuetracker.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="UserEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column
    private String email;
}
