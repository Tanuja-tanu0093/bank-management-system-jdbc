<%@ page import="com.bank.dto.Customer" %>
<%
    Customer user = (Customer) session.getAttribute("user");
    if(user == null){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand">Bank Dashboard</span>
        <a href="logout" class="btn btn-danger">Logout</a>
    </div>
</nav>

<div class="container">

    <div class="dashboard-box">
        <h4>Welcome, <%= user.getName() %></h4>
        <p><strong>Account Number:</strong> <%= user.getAccountNumber() %></p>
        <p><strong>Balance:</strong> ₹ <%= user.getBalance() %></p>
    </div>

    <div class="row">
        <div class="col-md-4 mb-3">
            <a href="deposit.jsp" class="btn btn-success w-100">Deposit</a>
        </div>
        <div class="col-md-4 mb-3">
            <a href="withdraw.jsp" class="btn btn-warning w-100">Withdraw</a>
        </div>
        <div class="col-md-4 mb-3">
            <a href="transfer.jsp" class="btn btn-info w-100">Transfer</a>
        </div>
        <div class="col-md-4 mb-3">
            <a href="transactions" class="btn btn-secondary w-100">Transactions</a>
        </div>
        <div class="col-md-4 mb-3">
            <a href="updateProfile.jsp" class="btn btn-primary w-100">Update Profile</a>
        </div>
        <div class="col-md-4 mb-3">
            <a href="updatePin.jsp" class="btn btn-dark w-100">Update PIN</a>
        </div>
    </div>

</div>

</body>
</html>