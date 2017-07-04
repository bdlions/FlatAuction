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
            System.import('resources/js/admin-template.js').catch(function (err) {
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
                    <nav class="navbar navbar-default left-panel-navbar-default margin-top-25px">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header left-panel-navbar-header-custom">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#left-panel" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <!--<a class="navbar-brand" href="#">Brand</a>-->
                            </div>
                            <div class="collapse navbar-collapse left-panel-navbar-collapse-custom" id="left-panel">
                                <div  class="left_menu form-group">
                                    <div id="set_admin_service_id" >
                                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-default admin-custom-panel">
                                                <a id="homepage" class="left-menu-anchor" href="" role="button">
                                                    <div class="panel-heading admin-custom-panel-heading" role="tab" id="headingOne">
                                                        <h4 class="panel-title">
                                                            Dashboard
                                                        </h4>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="panel panel-default admin-custom-panel">
                                                <div class="panel-heading admin-custom-panel-heading" role="tab" id="heading2" class="collapsed"  data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false" aria-controls="collapse2">
                                                    <h4 class="panel-title">
                                                        <a class="left-menu-anchor" role="button">Manage Users</a> <img class="pull-right margin-top-5px" src="resources/images/down-arrow.png"> 
                                                    </h4>
                                                </div>
                                                <div id="collapse2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading2">
                                                    <ul class="left-menu-unorder-list">
                                                        <a ><li>Registered Users</li></a>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="panel panel-default admin-custom-panel">
                                                <div class="panel-heading admin-custom-panel-heading" role="tab" id="heading3" class="collapsed"  data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false" aria-controls="collapse3">
                                                    <h4 class="panel-title">
                                                        <a class="left-menu-anchor" role="button">Manage Search Locations</a> <img class="pull-right margin-top-5px" src="resources/images/down-arrow.png"> 
                                                    </h4>
                                                </div>
                                                <div id="collapse3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading3">
                                                    <ul class="left-menu-unorder-list">
                                                        <a ><li>Create Search Location</li></a>
                                                        <a ><li>Show Search Locations</li></a>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="panel panel-default admin-custom-panel">
                                                <div class="panel-heading admin-custom-panel-heading" role="tab" id="heading4" class="collapsed"  data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="false" aria-controls="collapse4">
                                                    <h4 class="panel-title">
                                                        <a class="left-menu-anchor" role="button">Manage Properties</a> <img class="pull-right margin-top-5px" src="resources/images/down-arrow.png"> 
                                                    </h4>
                                                </div>
                                                <div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading4">
                                                    <ul class="left-menu-unorder-list">
                                                        <a ><li>Display Properties</li></a>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="panel panel-default admin-custom-panel" >
                                                <a class="left-menu-anchor"  role="button">
                                                    <div class="panel-heading admin-custom-panel-heading" role="tab" id="heading5">
                                                        <h4 class="panel-title">
                                                            Manage Landing Page Properties
                                                        </h4>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="panel panel-default admin-custom-panel" >
                                                <a class="left-menu-anchor"  role="button">
                                                    <div class="panel-heading admin-custom-panel-heading" role="tab" id="heading6">
                                                        <h4 class="panel-title">
                                                            Manage About Us
                                                        </h4>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="panel panel-default admin-custom-panel" >
                                                <a class="left-menu-anchor"  role="button">
                                                    <div class="panel-heading admin-custom-panel-heading" role="tab" id="heading7">
                                                        <h4 class="panel-title">
                                                            Manage Contact Us and Reply to User
                                                        </h4>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="panel panel-default admin-custom-panel">
                                                <a class="left-menu-anchor" href="" role="button">
                                                    <div class="panel-heading admin-custom-panel-heading" role="tab" id="headingTwelve">
                                                        <h4 class="panel-title">
                                                            <img src="resources/images/logout.png"> 
                                                            <b>Logout</b>
                                                        </h4>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </nav>
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


