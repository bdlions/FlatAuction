<!DOCTYPE html>
<html>
    <head>
        <title>Admin Panel</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" >
        <link rel="stylesheet" href="resources/css/font-awesome.min.css" >

        <!-- Optional theme -->
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="resources/css/admin-style.css" >


        <!-- Latest compiled and minified JavaScript -->
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>

        <!-- Polyfills -->
        <script src="resources/js/node_modules/core-js/client/shim.min.js"></script>
        <script src="resources/js/node_modules/zone.js/dist/zone.js"></script>
        <script src="resources/js/node_modules/systemjs/dist/system.src.js"></script>
        <script src="resources/js/non-member-template.config.js"></script>
        <script>
            System.import('resources/js/admin-template.js').catch(function(err) {
                console.error(err);
            });
        </script>
        <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"> 


    </head>
    <body>
        <header>
            <div class="container-fluid container-fluid-adjust header-bg">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
                        <a href="">
                            <img id="rm-site-logo" src="resources/images/logo.png"
                                 class="globalHeader-logo globalHeader-logo--rebranded" alt="Logo">
                        </a>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
                        <h3 class="header-title">Welcome to Admin panel</h3>
                    </div>
                </div>

            </div> 
        </header>

        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
                <jsp:include page="left-sidebar.jsp"></jsp:include>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
                <data-content>     
                    Loading...
                </data-content>
            </div>
        </div>

