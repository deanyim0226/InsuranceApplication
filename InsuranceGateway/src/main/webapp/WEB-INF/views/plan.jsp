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
                url:"getAllHealthPlans",
                success: function(response){
                    alert("successfully retrieved health plans")


                },
                error:function(err){
                    alert("error while retrieving health plans")
                }
            })
        })
    </script>
</head>
<body>


<div align="center">
    <h1>PLAN</h1>
    <div class="row">
        <div class="col-4">
            <h3>HMO</h3>
            <p> * Primarily revolve around a primary care physician (PCP).
                <br> * Everything is determined and coordinated through your PCP.
                <br> * All care falls within your local network of healthcare providers.
            </p>
            <div class="text-center">
                <a href="category?plan=something"  class="btn-default">select </a>
            </div>
            </div>
        <div class="col-4">
            <h3>EPO</h3>
            <p> * Primarily revolve around a primary care physician (PCP).
                <br> * Everything is determined and coordinated through your PCP.
                <br> * All care falls within your local network of healthcare providers.
            </p>
            <div class="text-center">
                <a href="category?plan=something" class="btn-default">select </a>
            </div>
        </div>
        <div class="col-4">
            <h3>PPO</h3>
            <p> * Primarily revolve around a primary care physician (PCP).
                <br> * Everything is determined and coordinated through your PCP.
                <br> * All care falls within your local network of healthcare providers.
            </p>
            <div class="text-center">
                <a href="category?plan=something"  class="btn-default">select </a>
            </div>
        </div>

    </div>
</div>



</body>
</html>

