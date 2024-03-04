<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="images/favicon.png" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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

            $("#cardContainer").on("click", ".select", function() {
                // Retrieve the data attributes
                var categoryType = $(this).attr("data-category");
                var healthPlanType = $(this).attr("data-healthPlan");

                localStorage.setItem("planType", healthPlanType)
                localStorage.setItem("categoryType", categoryType)

                window.location.replace("userInfo")
                // Example: You can use AJAX to send the selected data to the server
                // $.post("your-server-url", { categoryType: categoryType, healthPlanType: healthPlanType }, function(response) {
                //     console.log("Response from server:", response);
                // });
            });


            let categories = [];

            $.ajax({
                type:"GET",
                url:"getAllCategories",
                async:false,
                success: function(response){

                    $.each(response, function(index, category){
                        categories.push(category);
                    })
                },
                error:function(err){
                    alert("error while retrieving health plans")
                }
            })


            let healthPlans = [];

            $.ajax({
                type:"GET",
                url:"getAllHealthPlans",
                async:false,
                success: function(response){

                    $.each(response, function(index, healthPlan){
                        healthPlan.category = categories;
                        healthPlans.push(healthPlan);
                    })
                },
                error:function(err){
                    alert("error while retrieving health plans")
                }
            })

            let insurance = {};

            $.ajax({
                type:"GET",
                url:"getInsurance",
                async:false,
                success: function(response){
                    insurance = response;
                    insurance.plans = healthPlans;
                    alert("successfully retrieved Insruance")
                },
                error:function(err){
                    alert("error while retrieving health plans")
                }
            })

            var header = $("#header");
            header.append("<h1>"+ insurance.insuranceName + " Plans"+"</h1>")
            var cardContainer = $("#cardContainer");

            $.each(insurance.plans, function(healthIndex, healthPlans) {
                // Create a wrapper card for each row
                var wrapperCard = $("<div class='card'></div>");
                cardContainer.append(wrapperCard);

                var headerRow = $("<div class='row justify-content-center'></div>");
                wrapperCard.append(headerRow);

                var rowHeader = $("<h1 class='text-center'>" + healthPlans.planType + "</h1>");
                headerRow.append(rowHeader);

                var cardsRow = $("<div class='row mb-3'></div>");
                wrapperCard.append(cardsRow);

                $.each(healthPlans.category, function(categoryIndex, category) {
                    var cardContainer = $("<div class='col-3 mb-3'></div>"); // Added mb-3 for margin bottom

                    var card = $("<div class='card'></div>");
                    var cardBody = $("<div class='card-body'></div>");
                    var cardTitle = $("<h3 class='card-title'>" + category.categoryType + "</h3>");
                    var cardText1 = $("<p class='card-text'>" + category.description + "</p>");
                    var cardText2 = $("<p class='card-text'>" + category.feature + "</p>");
                    var cardText3 = $("<p class='card-text'><strong>" + "Decuctible"  +"</strong> $" + category.deductible + "</p>");
                    var cardText4 = $("<p class='card-text'><strong>" + "Co-Payment"  +"</strong> $" + category.coPayment + "</p>");
                    var cardText5 = $("<p class='card-text'><strong>" + "MaxOutOfPocket" +"</strong> $" + category.maxOutOfPocket + "</p>");

                    let monthlyFee = parseInt(category.price) + parseInt(healthPlans.monthlyFee)
                    var cardText6 = $("<p class='card-text'><strong>" + "Montly Fee" +"</strong> $" + monthlyFee+ "</p>");
                    var cardText7 = $("<input data-category='"+category.categoryType+"' data-healthPlan='"+healthPlans.planType+"' type='submit' class='select btn-default' value='Select'/>")

                    cardBody.append(cardTitle);
                    cardBody.append(cardText1);
                    cardBody.append(cardText2);
                    cardBody.append(cardText3);
                    cardBody.append(cardText4);
                    cardBody.append(cardText5);
                    cardBody.append(cardText6);
                    cardBody.append(cardText7);
                    card.append(cardBody);

                    cardContainer.append(card);
                    cardsRow.append(cardContainer);
                });
            });

        })
    </script>
</head>
<body>

<div id="header" align="center">

</div>
<div id=cardContainer align="center">

</div>

</body>
</html>

