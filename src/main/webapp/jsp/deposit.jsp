<!DOCTYPE html>
<html>
<head>
<title>Deposit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="card mx-auto col-md-6 mt-5">
			<div class="card-body">
				<h3 class="text-center">Deposit Money</h3>

				<form action="deposit" method="post">
					<div class="mb-3">
						<label>Amount</label> <input type="number" class="form-control"
							name="amount" required>
					</div>

					<button class="btn btn-success w-100">Deposit</button>
				</form>

				<a href="dashboard.jsp" class="btn btn-secondary w-100 mt-2">Back</a>
			</div>
		</div>
	</div>

</body>
</html>