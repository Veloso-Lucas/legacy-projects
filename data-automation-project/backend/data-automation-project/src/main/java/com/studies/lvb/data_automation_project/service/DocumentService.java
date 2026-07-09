package com.studies.lvb.data_automation_project.service;

import com.studies.lvb.data_automation_project.dto.DocumentDTO;
import com.studies.lvb.data_automation_project.model.Document;
import com.studies.lvb.data_automation_project.model.embeddable.FileStatus;
import com.studies.lvb.data_automation_project.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public DocumentDTO uploadFile(MultipartFile file) throws IOException {
        final Path path = Paths.get(uploadDir).normalize();

        // Create temp folder if not exists
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        // Create a new random name for uploaded file
        final String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Define temp directory path
        final Path filePath = path.resolve(uniqueFileName);

        // Save file in a temp Directory
        file.transferTo(filePath.toFile());

        // Save file info in Db
        Document document = Document.builder()
                .fileName(uniqueFileName)
                .fileContent(filePath.toString())
                .status(FileStatus.PENDING)
                .uploadDate(Calendar.getInstance())
                .build();

        document = documentRepository.save(document);

        return new DocumentDTO(document);
    }


    public List<DocumentDTO> findAll() {

        final List<Document> documents = documentRepository.findAll();


        return documents.stream()
                .map(DocumentDTO::new)
                .toList();
    }
}
