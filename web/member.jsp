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

        <script src="resources/js/node_modules/core-js/client/shim.min.js"></script>
        <script src="resources/js/node_modules/zone.js/dist/zone.js"></script>
        <script src="resources/js/global.js"></script>
        <script src="resources/js/member_bundle.js"></script>
        
<!--         Latest compiled and minified JavaScript 
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>

        <script src="resources/js/node_modules/systemjs/dist/system.src.js"></script>
        <script src="resources/js/non-member-template.config.js"></script>

        <script>
            System.import('resources/js/member-template.js').catch(function (err) {
                console.error(err);
            });            
        </script>-->
        <%
            String fbEmail = (String) request.getAttribute("fbEmail");
            String password = (String) request.getAttribute("password");
        %>
    </head>
    <body>
        <!--<div class="container">-->
            <!--<div class="row">-->
                <!--<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">-->
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
                <!--</div>-->
            <!--</div>-->
        <!--</div>-->
    </body>
    <script type="text/javascript">
            $(function() {
                localStorage.setItem("fbEmail", "<%out.print(fbEmail);%>");
                localStorage.setItem("password", "<%out.print(password);%>");
            });
    </script>
</html>