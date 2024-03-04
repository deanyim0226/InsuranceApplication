package com.example.insurancegateway.controller;

import com.example.insurancegateway.domain.ClientClaim;
import com.example.insurancegateway.domain.ClientDocument;
import com.example.insurancegateway.domain.Status;
import com.example.insurancegateway.service.ClaimService;
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
public class ClaimController {


    @Autowired
    ClaimService claimService;

    @PostMapping("uploadClaim")
    public ModelAndView uploadClaim(@RequestParam("file")MultipartFile files, @RequestParam("policyId")Long policyId, @RequestParam("description")String description) throws IOException {

        ModelAndView mav = new ModelAndView("claim");

        String fileName = StringUtils.cleanPath(files.getOriginalFilename());

        ClientClaim clientClaim = new ClientClaim();

        clientClaim.setPolicyId(policyId);
        clientClaim.setFileName(fileName);
        clientClaim.setFileType(files.getContentType());
        clientClaim.setData(files.getBytes());
        clientClaim.setStatus(Status.PENDING);
        clientClaim.setDescription(description);

        claimService.saveClaim(clientClaim);

        String downloadUrl = "";
        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/downloadClaim/")
                                .path(clientClaim.getId().toString())
                                        .toUriString();

        clientClaim.setDataUrl(downloadUrl);

        ClientClaim savedClaim = claimService.saveClaim(clientClaim);

        if(savedClaim == null){
            System.out.println("error while saving data");
        }else{
            mav.addObject("saved", true);
        }

        return mav;
    }

    @PostMapping("updateClaim/{claimId}/{status}")
    public ResponseEntity<?> updateClaim(@PathVariable String claimId, @PathVariable String status){


        ClientClaim updatedClaim = claimService.updateClaim(Long.valueOf(claimId),status);

        if(updatedClaim == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(updatedClaim);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(updatedClaim);
    }

    @GetMapping("downloadClaim/{id}")
    public ResponseEntity<?> download(@PathVariable Long id){

        ClientClaim claimInfo = claimService.getClaim(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(claimInfo.getFileType()))
                .body(claimInfo.getData());
    }

    @GetMapping("claimAdmin")
    public ModelAndView viewAllDocuments(){
        ModelAndView mav = new ModelAndView("claimAdmin");

        List<ClientClaim> claimList = claimService.getAll();

        mav.addObject("claims", claimList);

        return mav;
    }

}
