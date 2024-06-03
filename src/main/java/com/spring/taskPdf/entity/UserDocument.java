package com.spring.taskPdf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_documents")
public class UserDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number", unique=true)
    private String mobileNumber;

    @Column(name = "pincode")
    private String pincode;

    @Lob
    @Column(name = "pdf_data", columnDefinition = "LONGBLOB")
    private byte[] pdfData;

    public UserDocument() {}

    public UserDocument(String name, String address, String mobileNumber, String pincode, byte[] pdfData) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.pincode = pincode;
        this.pdfData = pdfData;
    }
}
