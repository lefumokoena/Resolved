<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	
	jQuery(document).ready(function(){
		jQuery("#userform").submit(function(e){
			jQuery(".formFieldError").remove();
			jQuery.ajax({
					url: jQuery(this).attr("action"),
					context: document.body,
					type: 'post',
					data:jQuery(this).serialize()
				}).done(function(res) {
					if(res.status==="ERROR"){
						for(var key in res.errorsMap){
							var err="<span class=\"formFieldError\" id=\""+key+"Id\">"+res.errorsMap[key]+"</span>";
							jQuery("[name^='"+key+"']").after(err);
						}
					}else{						
						jQuery("#msg").html("Form submitted");
					}
				}).fail(function(data){
					jQuery("#msg").html("<span class=\"formFieldError\">Server failed to process request</span>");
				});
			return false;
		});
	});
</script>
<style type="text/css">
.formFieldError{
color:red;
}
</style>
</head>
	<body>
	
		<form id="userform" action="submituser" method="post"  >
			Name  :<input type="text" name="name"/><br/>
			Email  :<input type="text" name="email"/><br/>
			Phone  :<input type="text" name="phone"/><br/>
			AddressLine1  :<input type="text" name="address.addressLine1"/><br/>
			AddressLine2  :<input type="text" name="address.addressLine2"/><br/>
			City  :<input type="text" name="address.city"/><br/>
			Pincode  :<input type="text" name="address.pincode"/><br/>
			<input type="submit"/>
		</form>
		<div id="msg"></div>
	
	</body>
</html>