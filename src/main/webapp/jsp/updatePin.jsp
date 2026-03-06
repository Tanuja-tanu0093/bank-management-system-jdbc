<!DOCTYPE html>
<html>
<head>
    <title>Update PIN</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="card mx-auto col-md-6 mt-5 shadow">
        <div class="card-body">
            <h3 class="text-center text-dark">Update PIN</h3>

            <form action="updatePin" method="post">
                <div class="mb-3">
                    <label class="form-label">New PIN</label>
                    <input type="password" class="form-control" name="newPin" required minlength="4">
                </div>

                <button class="btn btn-dark w-100">Update PIN</button>
            </form>

            <a href="dashboard.jsp" class="btn btn-secondary w-100 mt-3">Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>