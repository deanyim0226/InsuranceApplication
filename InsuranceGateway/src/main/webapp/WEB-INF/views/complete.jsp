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
            let clientInfo = JSON.parse(localStorage.getItem("client"))
            let paymentStatus = JSON.parse(localStorage.getItem("status"))

            $("#header").append(paymentStatus.status)

            let customer = JSON.parse(localStorage.getItem("user"))
            let address =JSON.parse(localStorage.getItem("address"))
            let healthPlanType = localStorage.getItem("planType")
            let categoryType = localStorage.getItem("categoryType")
            customer.address = address;

            if(paymentStatus.status === "succeeded"){

                customers = []

                $.ajax({
                    type:"POST",
                    url:"saveCustomer",
                    contentType:"application/json",
                    dataType:"json",
                    data:JSON.stringify(customer),
                    async: false,
                    success: function(response){
                        alert("successfully saved customer " + response);
                        customers.push(response)
                    },
                    error: function(err){
                        alert("error while saving customer");
                    }
                })

                let purchasedDate = new Date()
                purchaseInfo = { customers, purchasedDate,healthPlanType,categoryType  }

                purchasing = {}

                $.ajax({
                    type: "POST",
                    url:"savePurchase",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(purchaseInfo),
                    async: false,
                    success: function(response){
                        purchasing = response;
                        alert("successfully purchased insurance " + response);

                    },
                    error: function(err){
                        alert("error while saving customer");
                    }
                })
                let status = "PENDING"
                let insuredObj = {purchasing,status}

                $.ajax({
                    type:"POST",
                    url:"saveInsured",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(insuredObj),
                    async: false,
                    success: function(response){
                        alert("successfully generated insurance " + response);
                        var cardContainer = $("#cardContainer");
                        cardContainer.append("<h2>"+ "You have successfully purchased insurance" +"</h2>")
                        cardContainer.append("<h2>"+ "A mail has sent to your assoicated email" +"</h2>")
                        cardContainer.append("<h2>"+ "You need to update required docuements to obtain the insurance" +"</h2>")
                    },
                    error: function(err){
                        alert("error while generating insurance");
                    }

                })

            }


        })
    </script>
</head>
<body>

        <div align="center" class="justify-content-center">
            <h1 id="header">PURCHASING INSURANCE </h1>
        </div>
        <div id=cardContainer align="center">

        </div>

        <div class="text-center">
            <a href="home" id="back" class="btn-default">Home </a>
        </div>

</body>
</html>

