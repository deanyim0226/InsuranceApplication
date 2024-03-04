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
                    let purchaseId = $(element).attr("data-purchaseId");
                    let purchasing = {}

                    $.ajax({
                        type:"GET",
                        url:"getPurchaseById/"+purchaseId,
                        async: false,
                        success: function(response){
                            purchasing = response
                            alert("successfully retrieved purchase info" + purchasing.purchaseId)
                        },
                        error: function(error){
                            alert("error while retrieving purchase info")
                        }
                    })

                    let status = "APPROVED"
                    let dateOfEffective = new Date()

                    let insured = {purchasing, status, dateOfEffective}

                    $.ajax({
                        type:"POST",
                        contentType:"application/json",
                        dataType:"json",
                        url:"updateInsured",
                        data:JSON.stringify(insured),
                        async:false,
                        success:function(response){
                            insured = response;
                            alert("successfully updated insured" + response)
                        },
                        error:function(err){
                            alert("error while updating insured")
                        }
                    })

                    let policy = {insured}
                    $.ajax({
                        type:"POST",
                        contentType:"application/json",
                        dataType:"json",
                        url:"savePolicy",
                        data:JSON.stringify(policy),
                        async:false,
                        success:function(response){

                            alert("successfully saved policy" + response)
                        },
                        error:function(err){
                            alert("error while saving policy")
                        }
                    })

                    /*
                    update document in client side so that client can also check it
                     */
                    let documentId = $(element).attr("data-id");

                    status = "APPROVED"
                    $.ajax({
                        type:"POST",
                        contentType:"application/json",
                        dataType:"json",
                        url:"updateDocument/"+documentId +"/" + status,
                        data:JSON.stringify(),
                        async:false,
                        success:function(response){

                            alert("successfully update client document" + response)
                        },
                        error:function(err){
                            alert("error while saving client document")
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
                <th>Document-ID</th>
                <th>Purchase-ID</th>
                <th>Status</th>
                <th>View</th>

                <th colspan>ACTION</th>
                <th><a href="management">Back</a></th>
            </tr>

            <c:forEach items="${documents}" var="document">
                <tr>
                    <td>${document.getId()}</td>
                    <td>${document.getPurchaseId()}</td>
                    <td>${document.getStatus()}</td>
                    <td><a href="${document.getDataUrl()}">view</a></td>

                    <td><a class="approve" data-purchaseId='${document.getPurchaseId()}' data-id='${document.getId()}' href="">APPROVE</a></td>
                    <td><a href="">DENIED</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>

