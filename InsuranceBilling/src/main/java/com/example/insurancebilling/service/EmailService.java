package com.example.insurancebilling.service;

import com.example.insurancebilling.domain.Customer;
import com.example.insurancebilling.domain.Insured;
import com.example.insurancebilling.domain.Policy;
import com.example.insurancebilling.domain.Purchasing;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Async
    public void sendConfirmPolicy(Policy policy){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            //allow to set email contents with HTML using setContent
            MimeMessageHelper helper = new MimeMessageHelper(message);
            //allow to set the recipient, subject, and body of email
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(this.getEmailBodyConfirmPolicy(policy), "text/html;charset=UTF-8");

            Insured insuredInfo = policy.getInsured();

            Purchasing purchaseInfo = insuredInfo.getPurchasing();

            for(Customer customer : purchaseInfo.getCustomers()) {
                helper.setTo(customer.getEmail());
            }

            helper.setSubject("Insurance: Policy Information");
            helper.setText(this.getEmailBodyConfirmPolicy(policy),true);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);

            javaMailSender.send(message);

        }catch (Exception e){
            System.out.println("error occurs " + e.getMessage() );
            e.printStackTrace();
        }
    }

    @Async
    public void sendPolicyInformation(Policy policy){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            //allow to set email contents with HTML using setContent
            MimeMessageHelper helper = new MimeMessageHelper(message);
            //allow to set the recipient, subject, and body of email
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(this.getEmailBodyPolicy(policy), "text/html;charset=UTF-8");

            Insured insuredInfo = policy.getInsured();

            Purchasing purchaseInfo = insuredInfo.getPurchasing();

            for(Customer customer : purchaseInfo.getCustomers()) {
                helper.setTo(customer.getEmail());
            }

            helper.setSubject("Insurance: Policy Information");
            helper.setText(this.getEmailBodyPolicy(policy),true);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);

            javaMailSender.send(message);

        }catch (Exception e){
            System.out.println("error occurs " + e.getMessage() );
            e.printStackTrace();
        }
    }

    public String getEmailBodyConfirmPolicy(Policy policy){
        StringBuilder customerTable = new StringBuilder();

        Insured insuredInfo = policy.getInsured();

        Purchasing purchasing = insuredInfo.getPurchasing();

        for(Customer customer : purchasing.getCustomers()){
            String customerRow = """
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>       
                    </tr>
                    """.formatted(
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getGender(),
                    customer.getDateOfBirth()

            );

            customerTable.append(customerRow);
        }

        String htmlTemplate = """
                <!DOCTYPE html>
                <html>
          
                    <body>
                        <h1>Claim Documents are verified! </h1>

                        <h2> Claim Information </h2>

                        <p> We've verified your documents and decided to move forward your claim</>
                        <p> Your money will be reimbursed within 10 business days </p>
                   
                        <h2> Customer Information </h2>
                        <table>
                          
                            <tr>
                                <th>Customer Details</th>
                            </tr>
                            <tr>
                                <th> First Name </th>
                                <th> Last Name </th>
                                <th> Gender </th>
                                <th> DOB </th>
                            </tr>
                         
                            <tr>
                                 <td>%s</td>
                            </tr>

                        </table>
                        <hr/>
                   
                    </body>
                </html>
             """.formatted(
                customerTable.toString()
        );

        return htmlTemplate;

    }

    public String getEmailBodyPolicy(Policy policy){
        StringBuilder customerTable = new StringBuilder();

        Insured insuredInfo = policy.getInsured();

        Purchasing purchasing = insuredInfo.getPurchasing();

        for(Customer customer : purchasing.getCustomers()){
            String customerRow = """
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>       
                    </tr>
                    """.formatted(
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getGender(),
                    customer.getDateOfBirth()

            );

            customerTable.append(customerRow);
        }

        String htmlTemplate = """
                <!DOCTYPE html>
                <html>
                    <head>Insurance Confirmation</head>
                    <body>
                        <h1>Documents are verified! </h1>
                        <p> Effective Date : %s </p>
                        <p> For future reference policy Id : %d</p>
                        
                        <h2> Insurance Information </h2>
                        <p> Health Type : %s </p>
                        <p> Category Type : %s </p>
        
                        <h2> Customer Information </h2>
                        <table>
                          
                            <tr>
                                <th>Customer Details</th>
                            </tr>
                            <tr>
                                <th> First Name </th>
                                <th> Last Name </th>
                                <th> Gender </th>
                                <th> DOB </th>
                            </tr>
                         
                            <tr>
                                 <td>%s</td>
                            </tr>

                        </table>
                        <hr/>
                   
                    </body>
                </html>
             """.formatted(
                insuredInfo.getDateOfEffective(),
                policy.getPolicyId(),
                purchasing.getHealthPlanType(),
                purchasing.getCategoryType(),
                customerTable.toString()

        );

        return htmlTemplate;

    }
    @Async
    public void sendConfirmation(Purchasing purchasing){

        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            //allow to set email contents with HTML using setContent
            MimeMessageHelper helper = new MimeMessageHelper(message);
            //allow to set the recipient, subject, and body of email
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(this.getEmailBodyDocument(purchasing), "text/html;charset=UTF-8");

            for(Customer customer : purchasing.getCustomers()) {
                helper.setTo(customer.getEmail());
            }

            helper.setSubject("[Action required]: Documents are required to proceed");
            helper.setText(this.getEmailBodyDocument(purchasing),true);


            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);


            javaMailSender.send(message);

        }catch (Exception e){
            System.out.println("error occurs " + e.getMessage() );
            e.printStackTrace();
        }
    }

    public String getEmailBodyDocument(Purchasing purchasing){
        /*
        StringBuilder customerTable = new StringBuilder();

        for(Customer customer : purchasing.getCustomers()){
            String customerRow = """
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>       
                    </tr>
                    """.formatted(
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getGender(),
                            customer.getDateOfBirth()

            );

            customerTable.append(customerRow);
        }
        */
        String htmlTemplate = """
                <!DOCTYPE html>
                <html>
             
                    <body>
                        <h1>Payment is confirmed! </h1>
                        <p> Purchase Date : %s </p>
                        <p> For future reference purchase Id : %d</p>
                        <a href ='http://localhost:8080/document'> upload documents </a>
  
                    </body>
                </html>
             """.formatted(
                purchasing.getPurchasedDate(),
                purchasing.getPurchaseId()
        );

        return htmlTemplate;
    }
}
