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



        })
    </script>
</head>
<body>

<div class="get-quote-form">
    <h2>Get a free quote form</h2>

    <form class="quote-body" id="get-quote">
        <h3>Primary Applicant</h3>
        <div class="row">
            <div class="col-md-4">
                <label for="income">Income</label>
                <input type="text" id="income">
            </div>

            <div class="col-md-4">
                <label for="zipCode">Zip Code</label>
                <input type="text" id="zipCode">
            </div>

            <div class="col-md-4">
                <label for="gender">Gender</label>
                <select id="gender">
                    <c:forEach items="${genders}" var="gender">
                        <option label="${gender}" value="${gender}"></option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <label for="dob">Date of Birth</label>
                <input type="date" class="form-control"  id="dob">
            </div>

            <div class="col-md-6">
                <label for="date" class="form-label">Desired effective date?</label>
                <input type="date" class="form-control" id="date">
            </div>
        </div>
        <div class="row">
            <div class="text-center">
                <a href="plan" id="back" class="btn-default">Get Quotes Online</a>
            </div>
        </div>

    </form>
</div>

</body>
</html>

