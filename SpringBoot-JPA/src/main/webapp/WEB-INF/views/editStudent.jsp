<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Updation Form</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.has-error {
	color: red;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<h2>Student Information Details</h2>
		<c:url var="action" value="/update"/> 
		<form:form action="${action}" method="post" class="form-horizontal"
			modelAttribute="editStudent" novalidate="novalidate">

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="id">Id</label>
					<div class="col-md-7">
						<form:input type="text" path="id" id="id"
							class="form-control input-sm" readonly="true"/>
						<div class="has-error">
							<form:errors path="id" class="help-inline" />
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="firstName">FirstName</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="firstName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="lastName">Lastname</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="email" path="email" id="email"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="dob">DOB</label>
					<div class="col-md-7">
						<form:input type="date" path="dob" id="dob"
							class="form-control input-sm" readonly="true"/>
						<div class="has-error">
							<form:errors path="dob" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="section">Section</label>
					<div class="col-md-7" class="form-control input-sm">
						<form:radiobuttons path="section" id="section" items="${sections}" />
						<div class="has-error">
							<form:errors path="section" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="country">Country</label>
					<div class="col-md-7">
						<form:select path="country" id="country"
							class="form-control input-sm">
							<form:option value="">Select country</form:option>
							<form:options items="${countries}" />
						</form:select>
						<div class="has-error">
							<form:errors path="country" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="subjects">Subjects</label>
					<div class="col-md-7">
						<form:select path="subjects" id="subjects" items="${subjects}"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="subjects" class="help-inline" />
						</div>

					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="sex">Sex</label>
					<div class="col-md-7" class="form-control input-sm" >
						<form:radiobutton path="sex" value="M" />
						Male
						<form:radiobutton path="sex" value="F" />
						Female
						<div class="has-error">
							<form:errors path="sex" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-table" for="firstAttempt">FirstAttempt</label>
					<div class="col-md-1">
						<form:checkbox path="firstAttempt" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-actions flootRight">
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm">
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>