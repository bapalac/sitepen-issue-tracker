package com.sitepen.issuetracker.entity;

import com.sitepen.issuetracker.enums.TaskPriority;
import com.sitepen.issuetracker.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TaskEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column
    private Long assigneeId;

    @Column
    private Long projectId;
}
