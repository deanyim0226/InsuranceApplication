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
            /*
            retrieve insurance that user has chosen
            set the price into paymentRequest
            retrieve planType and categoryType
            display user information and insurance information
             */
            let user = JSON.parse(localStorage.getItem("user"));

            var cardContainer = $("#cardContainer2");
            var wrapperCard = $("<div class='card'></div>");
            cardContainer.append(wrapperCard);

            var headerRow = $("<div class='row justify-content-center'></div>");
            wrapperCard.append(headerRow);

            var rowHeader = $("<h1 class='text-center'>" +"Customer information" + "</h1>");
            headerRow.append(rowHeader);

            var cardsRow = $("<div class='row mb-3'></div>");
            wrapperCard.append(cardsRow);

            var card = $("<div class='card'></div>");
            var cardBody = $("<div class='card-body'></div>");
            var cardTitle1 = $("<h3 class='card-title'>" + "Personal Info" + "</h3>");
            var cardTitle2 = $("<h3 class='card-title'>" + "Address Info" + "</h3>");
            var cardText1 = $("<p class='card-text'><strong>" + "FirstName: "  +"</strong> " + user.firstName +  "<strong> LastName: </strong>" + user.lastName + "</p>");
            var cardText2 = $("<p class='card-text'><strong>" + "Email: " +"</strong> " + user.email + "</p>");
            var cardText3 = $("<p class='card-text'><strong>" + "Gender: "  +"</strong> " + user.gender +  "<strong> DOB: </strong>" + user.dateOfBirth + "</p>");
            var cardText4 = $("<p class='card-text'><strong>" + "Mobile-No: " +"</strong> " + user.mobileNo + "</p>");

            let address = JSON.parse(localStorage.getItem("address"));
            var cardText5 = $("<p class='card-text'><strong>" + "Address: " +"</strong> " + address.addressLine1 + " " + address.addressLine2 + "</p>");
            var cardText6 = $("<p class='card-text'><strong>City: </strong>" + address.city + "<strong> State: </strong>" + address.state + "<strong> Zipcode: </strong>" + address.zipcode + "</p>");

            cardBody.append(cardTitle1)
            cardBody.append(cardText1);
            cardBody.append(cardText2);
            cardBody.append(cardText3);
            cardBody.append(cardText4);
            cardBody.append(cardTitle2)
            cardBody.append(cardText5);
            cardBody.append(cardText6);
            card.append(cardBody);

            cardsRow.append(card);

            let planType = localStorage.getItem("planType")
            let categoryType = localStorage.getItem("categoryType")

            let selectedPlan
            let selectedCategory

            $.ajax({
                type:"GET",
                url:"getCategoryByType/" + categoryType,
                async:false,
                success: function(response){

                    selectedCategory = response;
                },
                error: function(error){
                    alert("error while retrieving category " + error);
                }
            })

            $.ajax({
                type: "GET",
                url:"getHealthPlanByType/" + planType ,
                async:false,
                success: function(response){
                    selectedPlan = response;
                },
                error: function (error){
                    alert("error while retrieving plan " + error);
                }
            })

            var cardContainer = $("#cardContainer2");
            var wrapperCard = $("<div class='card'></div>");
            cardContainer.append(wrapperCard);

            var headerRow = $("<div class='row justify-content-center'></div>");
            wrapperCard.append(headerRow);

            var rowHeader = $("<h1 class='text-center'>" +"Insurance information" + "</h1>");
            headerRow.append(rowHeader);

            var cardsRow = $("<div class='row mb-3'></div>");
            wrapperCard.append(cardsRow);

            var card = $("<div class='card'></div>");
            var cardBody = $("<div class='card-body'></div>");
            var cardTitle1 = $("<h3 class='card-title'>" + "HEALTH TYPE: " + selectedPlan.planType + "</h3>");
            var cardTitle2 = $("<h3 class='card-title'>" + "CATEGOTY: " + selectedCategory.categoryType + "</h3>");
            var cardText1 = $("<p class='card-text'>" + selectedCategory.description + "</p>");
            var cardText2 = $("<p class='card-text'>" + selectedCategory.feature + "</p>");
            var cardText3 = $("<p class='card-text'><strong>" + "Decuctible"  +"</strong> $" + selectedCategory.deductible + "</p>");
            var cardText4 = $("<p class='card-text'><strong>" + "Co-Payment"  +"</strong> $" + selectedCategory.coPayment + "</p>");
            var cardText5 = $("<p class='card-text'><strong>" + "MaxOutOfPocket" +"</strong> $" + selectedCategory.maxOutOfPocket + "</p>");

            let monthlyFee = parseInt(selectedCategory.price) + parseInt(selectedPlan.monthlyFee)
            var cardText6 = $("<p class='card-text'><strong>" + "Montly Fee" +"</strong> $" + monthlyFee+ "</p>");

            cardBody.append(cardTitle1)
            cardBody.append(cardTitle2);
            cardBody.append(cardText1);
            cardBody.append(cardText2);
            cardBody.append(cardText3);
            cardBody.append(cardText4);
            cardBody.append(cardText5);
            cardBody.append(cardText6);

            card.append(cardBody);
            cardsRow.append(card);

            let paymentRequest = {}

            $("#submit").click(function(){

                $.ajax({
                    type:"POST",
                    url:"create-stripe-customer",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(user),
                    async:false,
                    success: function(response){
                        alert("successfully created user " + response.stripeCustomerId);
                        paymentRequest = {"amount":monthlyFee, "paymentMethod":"pm_card_visa", "description":"insurance", "stripeId":response.stripeCustomerId};
                    },
                    error: function(error){
                        alert("error while creating stripe user")
                    }
                })


                $.ajax({
                    type:"POST",
                    url:"create-payment-intent",
                    dataType:"json",
                    contentType:"application/json",
                    data: JSON.stringify(paymentRequest),
                    async:false,
                    success: function(response){
                        alert("successfully retrieved payment intent " + response.intentId + "secret " + response.clientSecret);
                        localStorage.setItem("client",JSON.stringify(response))
                        setTimeout(function(){
                            window.location.replace("payment")
                        },1000)
                    },
                    error: function(err){
                        alert("erorr while creating payment intent")
                    }

                })



            })






        })
    </script>
</head>
<body>

        <div id=cardContainer1 align="center">

        </div>

        <div id=cardContainer2 align="center">

        </div>

        <div class="text-center">
            <a href="address" id="back" class="btn-default">Back </a>
            <a id="submit" class="btn-default">Payment </a>
        </div>

</body>
</html>

