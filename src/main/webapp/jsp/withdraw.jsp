<!DOCTYPE html>
<html>
<head>
    <title>Withdraw</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="card mx-auto col-md-6 mt-5 shadow">
        <div class="card-body">
            <h3 class="text-center text-warning">Withdraw Money</h3>

            <form action="withdraw" method="post">
                <div class="mb-3">
                    <label class="form-label">Enter Amount</label>
                    <input type="number" class="form-control" name="amount" required min="1">
                </div>

                <button class="btn btn-warning w-100">Withdraw</button>
            </form>

            <a href="dashboard.jsp" class="btn btn-secondary w-100 mt-3">Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>