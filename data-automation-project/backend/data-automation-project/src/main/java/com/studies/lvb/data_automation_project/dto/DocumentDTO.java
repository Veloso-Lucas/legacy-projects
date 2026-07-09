package com.studies.lvb.data_automation_project.dto;

import com.studies.lvb.data_automation_project.model.Document;
import com.studies.lvb.data_automation_project.model.embeddable.FileStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO implements Serializable {

    private String fileName;

    private String fileContent;

    private FileStatus status;

    private Calendar uploadDate;

    public DocumentDTO(Document document) {
        this.setFileName(document.getFileName());
        this.setFileContent(document.getFileContent());
        this.setStatus(document.getStatus());
        this.setUploadDate(document.getUploadDate());
    }
}
