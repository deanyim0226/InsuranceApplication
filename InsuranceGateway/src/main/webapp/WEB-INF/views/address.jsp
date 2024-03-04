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

            $("#next").click(function(){

                let addressLine1 = $("#addressLine1").val();
                let addressLine2 = $("#addressLine2").val();
                let city = $("#city").val();
                let state = $("#state").val();
                let zipcode = $("#zipCode").val();

                let address = {addressLine1,addressLine2,city,state,zipcode}

                localStorage.setItem("address",JSON.stringify(address));

                /*
                $.ajax({
                    type:"POST",
                    url:"http://localhost:8080/saveAddress",
                    contentType:"application/json",
                    dataType:"json",
                    data:JSON.stringify(address),
                    success: function(response){
                        alert("successfully saved" + response);
                    },
                    error: function(err){
                        alert("error while saving" + err)
                    }
                })
                 */
            })

        })
    </script>
</head>
<body>


    <div class="get-quote-form">
        <h2>Address Form</h2>

        <form class="quote-body" id="get-quote">
            <h3>Primary Applicant</h3>
            <div class="row">
                <div class="col-md-6">
                    <label for="addressLine1">Address Line1 </label>
                    <input path="addressLine1" type="text" id="addressLine1"/>
                </div>
                <div class="col-md-6">
                    <label for="addressLine2">Address Line2 </label>
                    <input path="addressLine2" type="text" id="addressLine2"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label for="city">City</label>
                    <input path="city" type="text" id="city"/>
                </div>
                <div class="col-md-4">
                    <label for="state">State</label>
                    <input path="state" type="text" id="state"/>
                </div>
                <div class="col-md-4">
                    <label for="zipCode">Zip Code</label>
                    <input path="zipcode" type="text" id="zipCode"/>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <a href="userInfo" id="back" class="btn-default">Back </a>
                    <a href="review" id="next" class="btn-default">Next</a>
                </div>
            </div>

        </form>

    </div>



</body>
</html>

