package com.spring.taskPdf.service;


import com.spring.taskPdf.entity.UserDocument;
import com.spring.taskPdf.repository.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserDocumentService {

    @Autowired
    private UserDocumentRepository userDocumentRepository;

    public void saveUserDocument(String name, String address, String mobileNumber, String pincode, MultipartFile pdfFile) throws IOException {
        UserDocument userDocument = new UserDocument(name, address, mobileNumber, pincode, pdfFile.getBytes());
        userDocumentRepository.save(userDocument);
    }
}
