package com.sitepen.issuetracker.entity;

import com.sitepen.issuetracker.enums.TaskPriority;
import com.sitepen.issuetracker.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ProjectEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long ownerId;

    @Column
    private String name;
}
