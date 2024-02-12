<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

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

        })
    </script>
</head>
<body>


<div class="get-quote-form">
    <h2>Get a free quote form</h2>

    <form class="quote-body" id="get-quote">


        <div class="col-md-6">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" name="name" id="firstName" placeholder="First Name" />
        </div>
        <div class="col-md-6">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" name="email" id="lastName" placeholder="Last Name" />
        </div>

        <div class="col-md-6">
            <label for="inputAddress1" class="form-label">Income</label>
            <input type="text" name="name" id="inputAddress1" placeholder="Income" />
        </div>
        <div class="col-md-6">
            <label for="inputAddress2" class="form-label">DOB</label>
            <input type="text" name="email" id="inputAddress2" placeholder="Date of Birth" />
        </div>

        <div class="col-md-12">
            <label for="phoneNo" class="form-label">Mobile No.</label>
            <input type="text" name="ph-no" id="phoneNo" placeholder="Phone no" />
        </div>

        <div class="text-center">
            <a href="address" id="back" class="btn-default">Back </a>
            <a href="plan" id="next" class="btn-default">Next </a>
        </div>



    </form>
</div>



</body>
</html>

