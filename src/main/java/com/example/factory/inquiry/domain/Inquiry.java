package com.example.factory.inquiry.domain;

import com.example.factory.global.domain.BaseEntity;
import com.example.factory.member.domain.Member;
import com.example.factory.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(indexes = @Index(name = "idx_inquiry_status", columnList = "status"))
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siteName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private LocalDate deliveryDate;

    private String contactName;

    private String contactPhone;

    private String contactEmail;

    private String message;

    @Enumerated(EnumType.STRING)
    private InquiryStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private Member assignee;

    @Builder(access = AccessLevel.PRIVATE)
    private Inquiry(String siteName, Product product, int quantity, LocalDate deliveryDate, String contactName, String contactPhone, String contactEmail, String message
    , InquiryStatus status, Member assignee) {
       this.siteName = siteName;
       this.product = product;
       this.quantity = quantity;
       this.deliveryDate = deliveryDate;
       this.contactName = contactName;
       this.contactPhone = contactPhone;
       this.contactEmail = contactEmail;
       this.message = message;
       this.status = status;
       this.assignee = assignee;
    }

    public static Inquiry createInquiry(String siteName, Product product, int quantity, LocalDate deliveryDate, String contactName, String contactPhone, String contactEmail, String message, InquiryStatus status) {
        return Inquiry.builder()
                .siteName(siteName)
                .product(product)
                .quantity(quantity)
                .deliveryDate(deliveryDate)
                .contactName(contactName)
                .contactPhone(contactPhone)
                .contactEmail(contactEmail)
                .message(message)
                .status(status)
                .build();
    }

    public void assignTo(Member assignee) {
        this.assignee = assignee;
    }

    public void updateStatus(InquiryStatus status) {
        this.status = status;
    }

    public void updateInquiryByUser(String siteName, Product product, int quantity, LocalDate deliveryDate,
                                    String contactName, String contactPhone, String contactEmail, String message) {
        this.siteName = siteName;
        this.product = product;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.message = message;
    }
}
