<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="card mx-auto col-md-6">
        <div class="card-body">
            <h3 class="text-center">Login</h3>

            <form action="login" method="post">
                <div class="mb-3">
                    <label>Email</label>
                    <input type="email" class="form-control" name="email" required>
                </div>

                <div class="mb-3">
                    <label>PIN</label>
                    <input type="password" class="form-control" name="pin" required>
                </div>

                <button class="btn btn-primary">Login</button>
            </form>

            <div class="text-center mt-3">
                <a href="register.jsp">Create Account</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>