<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>

 
 

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="<c:url value="resources/styles/bootstrap/3.3.5/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/styles/bootstrap/3.3.5/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/styles/pivotal.css" />" />
    <title>spring-microservices: Home</title>
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
        </div>
        
        <div class="row">
            
            <h1>Accounts Web - Home Page</h1>

 

            <ul>
                <li><a href="/accountList">View Account List</a></li>
            </ul>
            
        </div>
        
    </div>
        
</body>
</html>