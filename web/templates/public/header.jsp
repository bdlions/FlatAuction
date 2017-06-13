<!DOCTYPE html>
<html>
    <head>
        <title>Property Auction</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="resources/css/wave.css" >
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" >
        <link rel="stylesheet" href="resources/css/bootstrap.min.css.map" >

        <!-- Optional theme -->
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="resources/css/common.css" >
        <link rel="stylesheet" href="resources/css/nonmember.css" >
        <link rel="stylesheet" href="resources/css/font-awesome.min.css" >
        <link rel="stylesheet" href="resources/css/tabbed-panels.css" >
        <!--<link rel="stylesheet" href="resources/css/autocomplete-style.css" >-->


        <!-- Latest compiled and minified JavaScript -->
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>

        <!-- Polyfills -->
        <script src="resources/js/node_modules/core-js/client/shim.min.js"></script>
        <script src="resources/js/node_modules/zone.js/dist/zone.js"></script>
        <script src="resources/js/node_modules/systemjs/dist/system.src.js"></script>
        <script src="resources/js/non-member-template.config.js"></script>
        <!-- Polyfills -->
        <script src="resources/js/global.js"></script>
        <script>
            System.import('resources/js/non-member-template.js').catch(function (err) {
                console.error(err);
            });
        </script>
        <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"> 

    </head>
    <body>
        <header class="margin-top-bottom-10px">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-4 col-md-5 col-lg-6">
                        <a href="non-member.jsp"><img id="logo" src="resources/images/logo.png" class="img-responsive" alt="Logo"> </a>
                    </div>
                    <div class="col-xs-12 col-sm-8 col-md-7 col-lg-6">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <nav class="navbar navbar-default header-menu-layout">
                                    <div class="container-fluid">
                                        <div class="navbar-header">
                                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar-collapse" aria-expanded="false">
                                                <span class="sr-only">Toggle navigation</span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                            </button>
                                        </div>
                                        <div class="collapse navbar-collapse" id="header-navbar-collapse">
                                            <ul class="nav navbar-nav">
                                                <li><a href="">Home </a> <span class="header-menu-tag">|</span></li>
                                                <li><a href="">Search </a> <span class="header-menu-tag">|</span></li>
                                                <li><a href="">About </a> <span class="header-menu-tag">|</span></li>
                                                <li><a href="">Contact </a> <span class="header-menu-tag">|</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                </nav>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <ul class="social-icons">
                                    <li><a href="https://www.facebook.com/dialog/oauth?client_id=648645175170513&redirect_uri=http%3A%2F%2Flocalhost%3A8084%2FFlatAuction%2FSocialAuthServlet&scope=email%2Cuser_hometown%2Cpublish_actions%2Cuser_likes%2Cuser_status%2Cuser_about_me%2Cuser_location%2Cuser_birthday%2Cuser_photos%2Cuser_posts%2Cuser_friends%2Cuser_relationship_details%2Cuser_games_activity%2Cuser_relationships"> <img id="logo" src="resources/images/facebook.png" class="img-responsive" alt="facebook"></a></li>
                                    <li><a> <img id="logo" src="resources/images/google-plus.png" class="img-responsive" alt="google-plus"></a></li>
                                    <li><a> <img id="logo" src="resources/images/twitter.png" class="img-responsive" alt="twitter"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
