package com.studies.lvb.data_automation_project.model.base;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDateTime createdIn;

    private LocalDateTime updatedIn;

    @PrePersist
    protected void prePersist() {
        this.createdIn = LocalDateTime.now();
        this.updatedIn = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedIn = LocalDateTime.now();
    }
}
