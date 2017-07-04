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
        <link rel="stylesheet" href="resources/css/wave.css" >
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="resources/css/admin.css" >
        <link rel="stylesheet" href="resources/css/common.css" >
        <link rel="stylesheet" href="resources/css/member.css" >
        <link rel="stylesheet" href="resources/css/nonmember.css" >


        <!-- Latest compiled and minified JavaScript -->
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>

        <!-- Polyfills -->
        <script src="resources/js/node_modules/core-js/client/shim.min.js"></script>
        <script src="resources/js/node_modules/zone.js/dist/zone.js"></script>
        <script src="resources/js/node_modules/systemjs/dist/system.src.js"></script>
        <script src="resources/js/non-member-template.config.js"></script>
        <script src="resources/js/global.js"></script>
        <script>
            System.import('resources/js/admin-login-template.js').catch(function (err) {
                console.error(err);
            });
        </script>
        <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"> 


    </head>
    <body>
        <div class="container-fluid container-fluid-adjust header-bg">
            <header>
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
            </header>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
                    
                </div>
                <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
                    <style type="text/css">
                        .vertical-center {
                            min-height: 100%; 
                            min-height: 100vh;
                            display: flex;
                            align-items: center;
                        }
                    </style>
                    <data-content>
                        <div class="vertical-center">
                            <div class="sk-wave">
                                <div class="sk-rect sk-rect1"></div>
                                <div class="sk-rect sk-rect2"></div>
                                <div class="sk-rect sk-rect3"></div>
                                <div class="sk-rect sk-rect4"></div>
                                <div class="sk-rect sk-rect5"></div>
                            </div>
                        </div>
                    </data-content>
                </div>
            </div>
        </div> 


