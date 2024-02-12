<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

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
            $.ajax({
                type:"GET",
                url:"getAllCategories",
                success:function(response){
                    alert("successfully retrieved categories");
                    alert(response);
                },
                error:function(){
                    alert("error while retrieving categories");
                }
            })
        })
    </script>
</head>
<body>


<div align="center">
    <h1>CATEGORY</h1>
    <div class="row">
        <div class="col">
            <h3>BASIC</h3>
            <p> * Free preventative care
                <br> * First 3 office visits are a fixed copay (dollar amount) before deductible is reached
                <br> * High deductible
                <br> * Out-of-pocket maximum limit; which is the most you would pay in a calendar year if the worst happened.
            </p>
            <div class="text-center">
                <a href="home?plan=something"  class="btn-default">select </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <h3>BRONZE</h3>
            <p> * Free preventative care
                <br> * First 3 office visits are a fixed copay (dollar amount) before deductible is reached
                <br> * High deductible
                <br> * Out-of-pocket maximum limit; which is the most you would pay in a calendar year if the worst happened.
            </p>
            <div class="text-center">
                <a href="home?plan=something"  class="btn-default">select </a>
            </div>
        </div>
    </div>
    <div class="row">
    <div class="col">
        <h3>SLIVER</h3>
        <p> * Free preventative care
            <br> * Common services such as doctor visits, lab work, generic drugs, and emergency room visits for a set copay (dollar) amount without having to meet your deductible first.
            <br> * Mid-range deductible for major services such as outpatient surgery, hospitalization, etc.
            <br> * Out-of-pocket maximum limit; which is the most you would pay in a calendar year if the worst happened.
        </p>
        <div class="text-center">
            <a href="home?plan=something" class="btn-default">select </a>
        </div>
    </div>
    </div>
    <div class="row">
    <div class="col">
        <h3>GOLD</h3>
        <p> * Free preventative care
            <br> * Copays (fixed dollar amounts) for medical services if you select the Gold 80 Copay plan, or coinsurance (a percentage of the medical costs) if you select the Gold 80 Coinsurance plan.
            <br> * No deductible
            <br> * Out-of-pocket maximum limit; which is the most you would pay in a calendar year if the worst happened.
        </p>
        <div class="text-center">
            <a href="home?plan=something"  class="btn-default">select </a>
        </div>
    </div>
    </div>
    <div class="row">
    <div class="col">
        <h3>PLATINUM</h3>
        <p> * Free preventative care
            <br> * Copays (fixed dollar amounts) for all medical services
            <br> * No deductible
            <br> * Lowest out-of-pocket maximum limit (most you would pay in a calendar year if the worst happened) available of all the Obama Care plans offered.
        </p>
        <div class="text-center">
            <a href="home?plan=something"  class="btn-default">select </a>
        </div>
    </div>
    </div>
</div>



</body>
</html>

