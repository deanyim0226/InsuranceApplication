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

            $("#submit").click(function(){
                let purchaseId = $("#purchaseId").val()

                let documents = []

                const inputFile = new FormData($("#uploadForm")[0])

                alert(inputFile)

                /*
                save document that client uploads'
                tasks think about a way to convert file into json and send it to the server

                save insured with document created, purchase retrieved, and status with pending
                 */
                /*
                $.ajax({
                    type:"POST",
                    url:"saveDocument",
                    contentType:"application/json",
                    dataType:"json",
                    data: JSON.stringify(inputFile),
                    success: function(response){
                        alert("succesfully reponse " + response)
                    },
                    error: function(error){
                        alert("error  " + error)
                    }
                })


                 */
            })



        })
    </script>
</head>
<body>


<div class="get-quote-form">
    <h2>Document Form</h2>

    <form class="quote-body" id="uploadForm" method="post" action="uploadDocument" enctype="multipart/form-data">
        <h3>Upload Document</h3>
        <div class="row">
            <div class="col-md-6">
                <label for="purchaseId">Reference Id</label>
                <input name="purchaseId" path="purchaseId" type="text" id="purchaseId"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="file">File Upload</label>
                <input name="file" path="file" type="file" id="file"/>
            </div>

        </div>

        <c:if test="${saved}">
            <p>Successfully saved document</p>
        </c:if>
        <div class="row">
            <div class="text-center">
                <input type="submit" id="submit" class="btn-default" value="Submit">
            </div>
        </div>

    </form>


</div>

</body>
</html>

