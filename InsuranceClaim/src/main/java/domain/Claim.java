package domain;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Claim {

    @Id
    private Long claimId;

    private Long email; //to retrieve user data

    private String dataUrl;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfClaim;




}
