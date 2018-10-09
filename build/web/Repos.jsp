<%-- 
    Document   : Repos
    Created on : 25-Sep-2018, 21:58:33
    Author     : User
--%>

<%@page import="model.Repository"%>
<!DOCTYPE html>
<%@page import="model.User"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="shortcut icon" type="image/png" href="assets/images/favicon.png" />
        <meta name="description" content="Demo of Bootstrap 4 user profile card widget to show different styles of user card created with default card and other components.">
        <title>My Github Profile</title> 
        <!-- CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <style>
        .btn{border-radius: 0;}
        .btn-md {
            border-width: 0;
            outline: none;
            border-radius: 0;
            box-shadow: 2px 2px 2px rgba(0, 0, 0, .6);
            cursor: pointer;
        }    
        h3 {text-align: center;margin:40px;}
    </style>

    <body>
        <%User user = (User) request.getAttribute("auth");%>
        <h3 class="headalign">My Github Profile</h3>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card card-inverse" style="background-color: #333; border-color: #333;">
                        <div class="card-block">
                            <div class="row">
                                <div class="col-md-4 col-sm-4 text-center">
                                    <img src="<%=user.getAvatar_url()%>" alt="" class="btn-md" width="300" height="300">
                                </div>
                                <div class="col-md-8 col-sm-8">
                                    <h2 class="card-title">Name: <%=user.getName()%></h2>
                                    <p class="card-text"><strong>Bio: </strong> <%=user.getBio()%></p>
                                    <p class="card-text"><strong>Company: </strong> <%=user.getCompany()%></p>
                                    <p class="card-text"><strong>Location: </strong> <%=user.getLocation()%></p>
                                    <p class="card-text"><strong>URL: </strong> <%=user.getHtml_url()%></p>
                                    <p class="card-text"><strong>Email: </strong> <%=user.getEmail()%></p>
                                    <p class="card-text"><strong>Blog: </strong> <%=user.getBlog()%> </p>
                                    <p class="card-text"><strong>You created your Github account on  <%=user.getCreated_at()%> and updated on <%=user.getUpdated_at()%></strong></p>
                                    <p class="card-text"><strong><%=user.isTwo_factor_authentication()%></strong></p>
                                </div>         
                                <div class="col-md-4 col-sm-4 text-center">
                                    <h2><strong><%= user.getTotalRepositories()%></strong></h2>                    
                                    <p><small>Total Repositories</small></p>
                                    <button class="btn btn-primary btn-block btn-md"><span class="fa fa-facebook-square"></span> Like  </button>
                                </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <h2><strong><%=user.getFollowing()%></strong></h2>                    
                                    <p><small>Following</small></p>
                                    <button class="btn btn-success btn-block btn-md"><span class="fa fa-twitter-square"></span> Tweet </button>
                                </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <h2><strong><%=user.getFollowers()%></strong></h2>                    
                                    <p><small>Followers</small></p>
                                    <button type="button" class="btn btn-danger btn-block btn-md"><span class="fa fa-google-plus-square"></span> Follow </button>  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
    </body>