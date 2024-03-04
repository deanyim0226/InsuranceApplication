package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import service.ClaimService;

@RestController
public class ClaimController {

    @Autowired
    ClaimService claimService;
}
