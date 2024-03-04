<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="images/favicon.png" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/icons.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
    <link rel="stylesheet" type="text/css" href="css/flexslider.css " />
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">

    <style>
        #quote-body{
            width: 500px;
            height: 500px;

        }
    </style>

    <script src="../js/jquery-3.7.1.min.js"></script>
    <!--[if lt IE 8]><!-->

    <!--<![endif]-->
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    -->
    <script>
        $(document).ready(function(){

            $(".approve").each(function(index,element){

                $(element).click(function(){
                    let policyId = $(element).attr("data-policyId");
                    let claimId = $(element).attr("data-claimId");
                    let policy = {}


                    $.ajax({
                        type:"GET",
                        url:"getPolicyById/"+policyId,
                        async: false,
                        success: function(response){
                            policy = response
                            alert("successfully retrieved policy info" + policy.policyId)
                        },
                        error: function(error){
                            alert("error while retrieving policy info")
                        }
                    })

                    let status = "APPROVED"

                    $.ajax({
                        type:"POST",
                        contentType:"application/json",
                        dataType:"json",
                        url:"updateClaim/"+claimId+"/"+status,
                        async:false,
                        success:function(response){
                            alert("successfully updated claim" + response)

                            $.ajax({
                                type:"POST",
                                contentType:"application/json",
                                dataType:"json",
                                url:"updatePolicy",
                                data:JSON.stringify(policy),
                                success:function(response){

                                    alert("successfully saved policy and sent email" + response)
                                },
                                error:function(err){
                                    alert("error while saving policy")
                                }

                            })
                        },
                        error:function(err){
                            alert("error while updating claim")
                        }
                    })

                })

            })

            /*
            retrieve insured data
            if document is legit, update insured
            add policy, dateOfEffective, and status

            if update is success, then send email to client
            with policy as pdf?, dateOfEffective and status of insurance
             */
        })
    </script>
</head>
<body>


<div class="get-quote-form">
    <h2>Review Form</h2>

    <div class="container-fluid" align="center">
        <table class="table table-dark table-striped">
            <tr>

                <th>Policy-ID</th>
                <th>Description</th>
                <th>Status</th>
                <th>View</th>

                <th>ACTION</th>
                <th><a href="management">Back</a></th>
            </tr>

            <c:forEach items="${claims}" var="claim">
                <tr>

                    <td>${claim.getPolicyId()}</td>
                    <td>${claim.getDescription()}</td>
                    <td>${claim.getStatus()}</td>
                    <td><a href="${claim.getDataUrl()}">view</a></td>

                    <td><a class="approve" data-policyId='${claim.getPolicyId()}' data-claimId='${claim.getId()}'  href="">APPROVE</a></td>
                    <td><a href="">DENIED</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>





</div>

</body>
</html>

