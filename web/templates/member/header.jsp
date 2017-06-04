<!DOCTYPE html>
<html>
    <head>
        <title>Property Auction</title>
        <!-- Meta Files -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"> 

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="resources/css/wave.css" >
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" >
        <link rel="stylesheet" href="resources/css/font-awesome.min.css" >
        <link rel="stylesheet" href="resources/css/tabbed-panels.css" >

        <!-- Optional theme -->
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="resources/css/common.css" >
        <link rel="stylesheet" href="resources/css/member.css" >

        <!-- Latest compiled and minified JavaScript -->
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>

        <!-- Polyfills -->
        <script src="resources/js/node_modules/core-js/client/shim.min.js"></script>
        <script src="resources/js/node_modules/zone.js/dist/zone.js"></script>
        <script src="resources/js/node_modules/systemjs/dist/system.src.js"></script>
        <script src="resources/js/non-member-template.config.js"></script>
        <script src="resources/js/global.js"></script>

    </head>
    <body>
        <header>
            <div  class="header-white-bg">
                <div  class="container">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 form-group">
                            <a href="home.jsp">
                                <img id="rm-site-logo" src="resources/images/logo.png" class="img-responsive header-logo" alt="Logo">
                            </a>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-offset-6 col-md-3 col-lg-offset-6 col-lg-3 pull-right">
                            <div class="dropdown dropdown-img">
                                <button class="dropdown-img-custom-button dropdown-toggle  pull-right" type="button" id="dropdownMenuMember" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <img class="img-responsive" src="resources/images/member_icon.png">
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuMember">
                                    <li><a href="member.jsp">Dashboard</a></li>
                                    <li><a href="manage-advert.jsp">Manage Adverts</a></li>
                                    <li><a href="message.jsp">Messages</a></li>
                                    <li><a href="account.jsp">Account</a></li>
                                    <li><a href="profile.jsp">Profile</a></li>
                                    <li><a href="search.jsp">Search</a></li>
                                    <li><a href="profile.jsp#/logout/">Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-black-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <nav class="navbar navbar-default header-custom-navbar">
                                <div class="container-fluid header-navbar-container-fluid-adjust">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#member-header" aria-expanded="false">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                    </div>

                                    <div class="collapse navbar-collapse" id="member-header">
                                        <ul class="nav navbar-nav header-custom-nav">
                                            <li class="active"><a href="member.jsp">Dashboard</a></li>
                                            <li><a href="manage-advert.jsp">Manage Adverts</a></li>
                                            <li><a href="message.jsp">Messages</a></li>
                                            <li><a href="account.jsp">Account</a></li>
                                            <li><a href="profile.jsp">Profile</a></li>
                                            <li><a href="search.jsp">Search</a></li>
                                            <!--                                            <li class="dropdown">
                                                                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Search <span class="caret"></span></a>
                                                                                            <ul class="dropdown-menu">
                                                                                                <li><a href="">Basic Search</a></li>
                                                                                                <li><a href="">Advanced Search</a></li>
                                                                                            </ul>
                                                                                        </li>-->
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div> 
            </div> 
        </header>


