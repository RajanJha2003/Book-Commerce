<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ebook: Login</title>
    <%@include file="all_component/allCss.jsp"%>
    <style type="text/css">
        /* Use more specific selectors to avoid conflicts */
        .login-section {
            background-color: #f0f1f2;
            padding: 40px 0;
            min-height: 80vh;
        }
        
        .login-card {
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            border: none;
            background-color: white;
            margin-top: 20px;
        }
        
        .login-card .card-body {
            padding: 25px;
        }
        
        .login-card .card-title {
            color: #333;
            font-weight: 600;
            margin-bottom: 20px;
            text-align: center;
            font-size: 24px;
        }
        
        .login-card .form-group {
            margin-bottom: 20px;
        }
        
        .login-card .form-control {
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 8px 12px;
            height: auto;
        }
        
        .login-card .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
        }
        
        .login-card .btn-primary {
            padding: 8px 16px;
            font-weight: 500;
            border-radius: 4px;
            width: 100%;
            margin-bottom: 15px;
        }
        
        .login-card .text-center a {
            color: #007bff;
            display: inline-block;
            margin: 5px 0;
        }
        
        .login-card .text-center a:hover {
            color: #0056b3;
        }
        
        .login-card .alert {
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 15px;
        }
        
        .login-card .text-danger {
            color: #dc3545;
        }
        
        .login-card .text-success {
            color: #28a745;
        }
    </style>
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
    
    <section class="login-section">
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card login-card">
                        <div class="card-body">
                            <h3 class="card-title">Login</h3>
                            
                            <% String failedMsg = (String) session.getAttribute("failedMsg");
                               if (failedMsg != null) { %>
                                <div class="alert alert-danger">
                                    <%= failedMsg %>
                                </div>
                            <% session.removeAttribute("failedMsg");
                               } %>
                               
                            <% String succMsg = (String) session.getAttribute("succMsg");
                               if (succMsg != null) { %>
                                <div class="alert alert-success">
                                    <%= succMsg %>
                                </div>
                            <% session.removeAttribute("succMsg");
                               } %>
                            
                            <form action="login" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1"
                                        aria-describedby="emailHelp" required="required" name="email">
                                </div>
                                
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1"
                                        required="required" name="password">
                                </div>
                                
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Login</button>
                                    <br>
                                    <a href="forgot.jsp" style="text-decoration: none;">Forgot Password</a>
                                    <br>
                                    <a href="register.jsp" style="text-decoration: none;">Create Account</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>