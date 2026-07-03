package com.example.factory.document.domain;

import com.example.factory.global.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Document extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentType docType;

    private String title;

    private String s3Key;

    private String fileName;

    private LocalDate issuedDate;

    private LocalDate expiryDate;

    @Builder(access = AccessLevel.PRIVATE)
    public Document(DocumentType docType, String title, String s3Key, String fileName, LocalDate issuedDate, LocalDate expiryDate) {
        this.docType = docType;
        this.title = title;
        this.s3Key = s3Key;
        this.fileName = fileName;
        this.issuedDate = issuedDate;
        this.expiryDate = expiryDate;
    }

    public static Document createDocument(DocumentType docType, String title, String s3Key, String fileName, LocalDate issuedDate, LocalDate expiryDate) {
        return Document.builder()
                .docType(docType)
                .title(title)
                .s3Key(s3Key)
                .fileName(fileName)
                .issuedDate(issuedDate)
                .expiryDate(expiryDate)
                .build();
    }

    public void updateDocument(DocumentType docType, String title, String s3Key, String fileName, LocalDate issuedDate, LocalDate expiryDate) {
        this.docType = docType;
        this.title = title;
        this.s3Key = s3Key;
        this.fileName = fileName;
        this.issuedDate = issuedDate;
        this.expiryDate = expiryDate;
    }
}
