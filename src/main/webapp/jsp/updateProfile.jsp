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
    <title>Update Profile</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="card mx-auto col-md-6 mt-5 shadow">
        <div class="card-body">
            <h3 class="text-center text-primary">Update Profile</h3>

            <form action="updateProfile" method="post">
                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name"
                           value="<%= user.getName() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" name="email"
                           value="<%= user.getEmail() %>" required>
                </div>

                <button class="btn btn-primary w-100">Update</button>
            </form>

            <a href="dashboard.jsp" class="btn btn-secondary w-100 mt-3">Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>