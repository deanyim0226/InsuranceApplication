package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClaimRepository;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;


}
