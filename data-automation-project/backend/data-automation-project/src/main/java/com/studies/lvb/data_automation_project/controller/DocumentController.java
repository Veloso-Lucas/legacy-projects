package com.studies.lvb.data_automation_project.controller;

import com.studies.lvb.data_automation_project.dto.DocumentDTO;
import com.studies.lvb.data_automation_project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File cannot be empty");
        }

        try {
            final DocumentDTO documentDTO = documentService.uploadFile(file);
            return ResponseEntity.ok(documentDTO);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error to save the file : " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<DocumentDTO>> findAll() {
        final List<DocumentDTO> documentDTOS =  documentService.findAll();
        return ResponseEntity.ok(documentDTOS);
    }
}
