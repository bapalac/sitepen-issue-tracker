package com.sitepen.issuetracker.entity;

import com.sitepen.issuetracker.enums.IssuePriority;
import com.sitepen.issuetracker.enums.IssueStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="IssueEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    @Enumerated(EnumType.STRING)
    private IssuePriority priority;

    @Column
    private Long assigneeId;

    @Column
    private Long projectId;
}
