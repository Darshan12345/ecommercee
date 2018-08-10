<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Fill the below information to Register Customer:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="customer">


        <h3>Basic Informatin</h3>


        <div class="form-group">
        <label for="name">Name</label>
        <form:input path="customerName"  id="name" class="form-control"></form:input>
        </div>
        <div clas="form-group">
            <label for="email">email</label>
            <form:input path="customerEmail" id="email" class="form-control"></form:input>

        </div>

        <div class="form-group">

            <label for="phone">Phone number:</label>
            <form:input path="customerPhone" id="phone" class="form-control"></form:input>
        </div>

        <div class="form-group">

            <label for="userName">Username</label>
            <form:input path="username" id="username" class="form-control"></form:input>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <form:password path="password" id="password" class="form-control"></form:password>

        </div>

        <h3>Billing Address</h3>



        <div class="form-group">
            <label for="billingstreetName">Street</label>
            <form:input path="billingAddress.streetName" id="billingstreetName" class="form-control"></form:input>
        </div>



        <div class="form-group">
            <label for="apartNumber">apartNumber</label>
            <form:input path="billingAddress.apartmentNumber" id="apartNumber" class="form-control"></form:input>
        </div>


        <div class="form-group">
            <label for="city">city</label>
            <form:input path="billingAddress.city" id="city" class="form-control"></form:input>
        </div>


        <div class="form-group">
            <label for="state">state</label>
            <form:input path="billingAddress.state" id="state" class="form-control"></form:input>
        </div>


        <div class="form-group">
            <label for="country">country</label>
            <form:input path="billingAddress.country" id="country" class="form-control"></form:input>
        </div>

        <div class="form-group">
            <label for="zipcode">zipcode</label>
            <form:input path="billingAddress.zipCode" id="zipcode" class="form-control"></form:input>
        </div>

        <h3>Shipping Address</h3>


        <div class="form-group">
            <label for="shippingstreetName">Street</label>
            <form:input path="shippingAddress.streetName" id="shippingstreetName" class="form-control"></form:input>
        </div>



        <div class="form-group">
            <label for="apartNumber">apartNumber</label>
            <form:input path="shippingAddress.apartmentNumber" id="apartNumber" class="form-control"></form:input>
        </div>


        <div class="form-group">
            <label for="city">city</label>
            <form:input path="shippingAddress.city" id="city" class="form-control"></form:input>
        </div>


        <div class="form-group">
            <label for="state">state</label>
            <form:input path="shippingAddress.state" id="state" class="form-control"></form:input>
        </div>


        <div class="form-group">
            <label for="country">country</label>
            <form:input path="shippingAddress.country" id="country" class="form-control"></form:input>
        </div>

        <div class="form-group">
            <label for="zipcode">zipcode</label>
            <form:input path="shippingAddress.zipCode" id="zipcode" class="form-control"></form:input>
        </div>



        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
