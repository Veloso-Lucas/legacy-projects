package com.studies.lvb.data_automation_project.model;

import com.studies.lvb.data_automation_project.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String encryptedPassword;

}
