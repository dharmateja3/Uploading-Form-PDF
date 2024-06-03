package com.spring.taskPdf.controller;


import com.spring.taskPdf.service.UserDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UserDocumentController {

    private static final long MAX_FILE_SIZE = 100 * 1024 * 1024; // 100MB

    @Autowired
    private UserDocumentService userDocumentService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadUserDocument(@RequestParam("name") String name,
                                     @RequestParam("address") String address,
                                     @RequestParam("mobileNumber") String mobileNumber,
                                     @RequestParam("pincode") String pincode,
                                     @RequestParam("pdfFile") MultipartFile pdfFile,
                                     Model model) {
        if (pdfFile.getSize() > MAX_FILE_SIZE) {
            model.addAttribute("message", "File size exceeds the 100MB limit!");
            return "index";
        }
        try {
            userDocumentService.saveUserDocument(name, address, mobileNumber, pincode, pdfFile);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "File upload failed!");
            e.printStackTrace();
        }
        return "index";
    }
}
