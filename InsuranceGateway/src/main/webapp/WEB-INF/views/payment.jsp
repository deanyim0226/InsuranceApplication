<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Accept a payment</title>
    <meta name="description" content="A demo of a payment on Stripe" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="../css/checkout.css" />
    <script src="../js/checkout.js" defer></script>
    <script src="../js/jquery-3.7.1.min.js"></script>
    <script src="https://js.stripe.com/v3/"></script>
    <script>
        $(document).ready(function(){

            let clientInfo = JSON.parse(localStorage.getItem("client"))

            $("#submit").click(function(){

                $.ajax({
                    type:"POST",
                    url:"confirm-payment",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(clientInfo),
                    success: function(response){
                        alert("successfully confirm" + response)
                        localStorage.setItem("status",JSON.stringify(response))

                        window.location.replace("complete")


                    },
                    error: function(err){
                        alert("error while confirming the payment")
                    }
                })

                return false;

            })


        })
    </script>
</head>
<body>
<!-- Display a payment form -->
<form id="payment-form">
    <div id="card-element">
    </div>
    <div id="payment-element">
        <!--Stripe.js injects the Payment Element-->
    </div>
    <button id="submit">
        <div class="spinner hidden" id="spinner"></div>
        <span id="button-text">Pay now</span>
    </button>
    <div id="payment-message" class="hidden"></div>
</form>

</body>
</html>