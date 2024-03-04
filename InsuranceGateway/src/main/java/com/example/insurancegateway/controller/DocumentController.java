package com.example.insurancegateway.controller;

import com.example.insurancegateway.domain.ClientDocument;
import com.example.insurancegateway.domain.Status;
import com.example.insurancegateway.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @PostMapping("/uploadDocument")
    public ModelAndView saveDocument(@RequestParam("file")MultipartFile files, @RequestParam("purchaseId")Long purchaseId) throws IOException {

        ModelAndView mav = new ModelAndView("document");

        String fileName = StringUtils.cleanPath(files.getOriginalFilename());

        ClientDocument clientDocument = new ClientDocument();

        clientDocument.setPurchaseId(purchaseId);
        clientDocument.setFileName(fileName);
        clientDocument.setData(files.getBytes());
        clientDocument.setFileType(files.getContentType());
        clientDocument.setStatus(Status.PENDING);

        documentService.saveClientDocument(clientDocument);

        String downloadUrl = "";
        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadDocument/")
                .path(clientDocument.getId().toString())
                .toUriString();

        clientDocument.setDataUrl(downloadUrl);


        ClientDocument savedClientDocument = documentService.saveClientDocument(clientDocument);

        if(savedClientDocument == null){
            System.out.println("error while saving data");
        }else{
            mav.addObject("saved", true);
        }

        return mav;
    }


    @PostMapping("updateDocument/{id}/{status}")
    public ResponseEntity<?> updateDocument(@PathVariable Long id, @PathVariable String status){

        ClientDocument updateDocument = documentService.updateClientDocument(id,status);
        if(updateDocument == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(updateDocument);
        }

        return ResponseEntity.status(HttpStatus.OK).body(updateDocument);
    }

    @GetMapping("downloadDocument/{id}")
    public ResponseEntity<?> download(@PathVariable Long id){

        ClientDocument clientDocument = documentService.getDocument(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(clientDocument.getFileType()))
                .body(clientDocument.getData());
    }

    @GetMapping("documentAdmin")
    public ModelAndView viewAllDocuments(){
        ModelAndView mav = new ModelAndView("documentAdmin");

        List<ClientDocument> clientDocumentList = documentService.getAll();

        mav.addObject("documents", clientDocumentList);

        return mav;
    }

}
