package com.sitepen.issuetracker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="placeholder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceholderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeholderId;

    @Column
    private String placeholderString;
}
