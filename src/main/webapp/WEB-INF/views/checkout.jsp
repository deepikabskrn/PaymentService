<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<style>
#ib2-button {
color: rgb(255, 255, 255);
background-color: rgb(45, 103, 153);
border-color: rgb(17, 75, 125); 
border-radius: 5px; 
text-shadow: rgb(74, 74, 74) 1px 1px 0px; 
background-image: none; 
font-size: 26px;"
}
</style>
</head>
<body>
<form action='/charge' method='POST' id='checkout-form'>
    <input type='hidden' value='<c:out value="${amount}"/>' name='amount' id='amount'/>
	<input type='hidden' value='<c:out value="${currency}"/>' name='currency' id='currency'/>
    <label>Price:<span><c:out value="${amount/100}"/> </span></label>
<c:out value ="${currency}"/>
<input id="stripe-pmnt-btn" class="ib2-button" type="submit"
 value="Pay with Card"
 data-key='<c:out value= "${stripePublicKey}"/>'
 data-amount='<c:out value="${amount}"/>'
 data-currency='<c:out value ="${currency}"/>'
 data-name="Sample Payment Inc"
 data-description="Stripe payment for $50">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<script src="https://checkout.stripe.com/v2/checkout.js"></script>
 <script>
 jQuery(document).ready(function(){	
	 jQuery("#stripe-pmnt-btn").on("click",function(e){
		 e.preventDefault();var t=jQuery(this),n=t.parents("form"),r=jQuery.extend({},t.data(),
			 {
			 token:function(e){
				 n.append(jQuery("<input>").attr({type:"hidden",name:"stripeToken",value:e.id })).submit()
			 }
	 		 });
 			StripeCheckout.open(r)
		 })
});
 </script>
</form>
</body>

</html>