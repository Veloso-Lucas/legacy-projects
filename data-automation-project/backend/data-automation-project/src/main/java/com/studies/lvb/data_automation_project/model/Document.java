package com.studies.lvb.data_automation_project.model;

import com.studies.lvb.data_automation_project.model.base.BaseEntity;
import com.studies.lvb.data_automation_project.model.embeddable.FileStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document extends BaseEntity {

    private String fileName;

    private String fileContent;

    private FileStatus status;

    private Calendar uploadDate;
}
