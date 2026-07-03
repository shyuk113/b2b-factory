package com.example.factory.document.infrastructure;

import com.example.factory.document.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
