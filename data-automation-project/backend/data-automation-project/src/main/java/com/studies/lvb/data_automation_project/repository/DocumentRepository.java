package com.studies.lvb.data_automation_project.repository;

import com.studies.lvb.data_automation_project.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> { }
