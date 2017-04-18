<!DOCTYPE html>
<html>
    <head>
        <title>Property Auction</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" >
        <link rel="stylesheet" href="resources/css/font-awesome.min.css" >
        <link rel="stylesheet" href="resources/css/autocomplete-style.css" >

        <!-- Optional theme -->
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="resources/css/header-menu.css" >
        <link rel="stylesheet" href="resources/css/style.css" >

        <!-- Latest compiled and minified JavaScript -->
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>

        <!-- Polyfills -->
        <script src="resources/js/node_modules/core-js/client/shim.min.js"></script>
        <script src="resources/js/node_modules/zone.js/dist/zone.js"></script>
        <script src="resources/js/node_modules/systemjs/dist/system.src.js"></script>
        <script src="resources/js/non-member-template.config.js"></script>
        <!-- Polyfills -->
        <script src="resources/js/header-menu.js"></script>
        <script src="resources/js/ga.js"></script>
        <script>
            System.import('resources/js/non-member-template.js').catch(function(err) {
                console.error(err);
            });
        </script>
        <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"> 


    </head>
    <body class="margin-top-bottom-100px">
        <header class="globalHeader  header-rebranding"
                id="globalHeader">
            <div class="globalNav-wrapper">
                <a href="">
                    <img id="rm-site-logo" src="resources/images/logo.png"
                         class="globalHeader-logo globalHeader-logo--rebranded" alt="Logo">
                </a><nav class="globalNav">
                    <ul class="globalNav-content">
                        <li class="globalNav-item">
                            <a class="globalNav-link" href="" data-analytics-label="">
                                Menu 1
                            </a>
                            <div class="globalNav-subNav">
                                <ul class="globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 1</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 2</a>
                                    </li>
                                </ul>
                                <ul class="globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 3</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 4</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 5</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="globalNav-item">
                            <a class="globalNav-link" href="" data-analytics-label="rent">
                                Menu 2
                            </a>
                            <div class="globalNav-subNav">
                                <ul class="globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 1</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 2</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="globalNav-item globalNav-item-findAgents">
                            <a class="globalNav-link" href="" data-analytics-label="">
                                Menu 3
                            </a>
                            <div class="globalNav-subNav">
                                <ul class="globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 1</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 2</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="globalNav-item">
                            <a class="globalNav-link" href="" data-analytics-label="">
                                Menu 4
                            </a>
                            <div class="globalNav-subNav">
                                <ul class="globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 1</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 2</a>
                                    </li>
                                </ul>
                                <ul class="globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 3</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 4</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="globalNav-item globalNav-item-commercial">
                            <a class="globalNav-link" href="" data-analytics-label="commercial">
                                Menu 5
                            </a>
                            <div class="globalNav-subNav">
                                <ul class="globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 1</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 2</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="globalNav-item globalNav-item-overseas">
                            <a class="globalNav-link" href="" data-analytics-label="">
                                Menu 6
                            </a>
                            <div class="globalNav-subNav">
                                <ul class="reverseBorder globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 1</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 2</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 3</a>
                                    </li>
                                </ul>
                                <ul class="reverseBorder globalNav-subNav-col">
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 4</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 5</a>
                                    </li>
                                    <li class="globalNav-subNav-item">
                                        <a class="globalNav-subNav-link" href=""
                                           data-analytics-label="">Sub Menu 6</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                    </ul>
                </nav>

            </div>
            <div class="globalNav-background"></div>
            <div class="globalHeader-background"></div>
        </header>