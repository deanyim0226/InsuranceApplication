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

            $("#next").click(function() {
                let firstName = $("#firstName").val();
                let lastName = $("#lastName").val();
                let gender = $("#gender").val();
                let dateOfBirth = $("#dob").val();
                let income = $("#income").val();
                let mobileNo = $("#phoneNo").val();
                let email = $("#email").val();

                let user = {email,firstName,  lastName, gender, dateOfBirth, income, mobileNo}

                localStorage.setItem("user",JSON.stringify(user));

            })


        })
    </script>
</head>
<body>


<div class="get-quote-form">
    <h2>User-Info Form</h2>

    <form class="quote-body" id="get-quote">
        <h3>Primary Applicant</h3>

        <div class="row">

            <div class="col-md-6">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" name="name" id="firstName" placeholder="First Name" />
            </div>
            <div class="col-md-6">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" name="email" id="lastName" placeholder="Last Name" />
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <label for="dob" class="form-label">DOB</label>
                <input type="date" class="form-control" name="dob" id="dob" placeholder="Date of Birth" />
            </div>

            <div class="col-md-6">
                <label for="gender" class="form-label">Gender</label>
                <select id="gender">
                    <c:forEach items="${genders}" var="gender">
                        <option label="${gender}" value="${gender}"></option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row">

            <div class="col-md-4">
                <label for="email" class="form-label">Email</label>
                <input type="text" name="email" id="email" placeholder="Email" />
            </div>

            <div class="col-md-4">
                <label for="income" class="form-label">Income</label>
                <input type="text" name="name" id="income" placeholder="Income" />
            </div>

            <div class="col-md-4">
                <label for="phoneNo" class="form-label">Mobile No.</label>
                <input type="text" name="ph-no" id="phoneNo" placeholder="Phone no" />
            </div>

        </div>

        <div class="text-center">
            <a href="address" id="next"  class="btn-default">Next </a>
        </div>
    </form>


</div>

</body>
</html>

