<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>

 

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

 

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

 

    <title>spring-microservices: Account Details</title>
</head>

 

<body>

 

    <div class="container">
        <div class="row">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                    </div>
                    <div>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="http://www.pivotal.io">
                                    <img alt="bank" title="Bank" height="120" src="<c:url value="images/download.jpg" />" />
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div style="text-align: right">[ <a href="<c:url value='/'/>">Home</a>
              | <a href="accountList">Accounts</a> ]</div>
        </div>
        
        <div class="row">
            
            <h1>Account Details</h1>
            
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-3">
                        Account ID:
                    </div>
                    <div class="col-sm-9">
                        ${account.id}
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-sm-3">
                        Name:
                    </div>
                    <div class="col-sm-9">
                        ${account.name}
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-sm-3">
                        Account Type:
                    </div>
                    <div class="col-sm-9">
                        ${account.type}
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-sm-3">
                        Amount:
                    </div>
                    <div class="col-sm-9">
                        ${account.amount}
                    </div>
                </div>
            </div>
                                
        </div>

 

    </div>

 

</body>

 

</html>