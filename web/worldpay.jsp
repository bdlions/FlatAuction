<%@page import="com.auction.util.WorldPayConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>WorldPay Payment Submission</title>

        <style type="text/css" media="screen">

            body {
                font-size:13pt

            }

            .mainBody { 
                width: 700px;
                margin-left: auto;
                margin-right: auto;
                border:solid;
                text-align:left;
                background: -moz-linear-gradient(top, #deefff 0%, #98bede 100%);
                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#deefff), color-stop(100%,#98bede));
                background: -webkit-linear-gradient(top, #deefff 0%,#98bede 100%);
                background: -o-linear-gradient(top, #deefff 0%,#98bede 100%);
                background: -ms-linear-gradient(top, #deefff 0%,#98bede 100%);
                background: linear-gradient(to bottom, #deefff 0%,#98bede 100%);
                filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#deefff', endColorstr='#98bede',GradientType=0 );

            }

            .divtable {
                display: table;	
                width: 500px;
                margin-left: auto;
                margin-right: auto;
            }

            .row {
                width: 60%;
                margin-left: auto;
                margin-right: auto;
                padding: 5px; 	
            }

            .cell {

                float: center; 
                margin: 2px; 
                padding: 5px; 
                text-align: center;
            }

            .cellLeft {

                float: left; 
                margin: 0; 
                padding: 0; 
                width: 50%;
                text-align:left;
            }

            .cellRight {

                float: right; 
                margin: 0; 
                padding: 0; 
                width: 50%;
            }

            #wpLogo {
                text-align: center;

            }

            #logoDisplay	{
                text-align: center;
            }

            #payButton	{
                text-align: center;
                padding: 4px;
            }		

        </style>
    </head>

    <%
        int amount = 10;
        String currencyCode = WorldPayConfig.getInstance().get(WorldPayConfig.CURRENCY_CODE);
        String testMode = WorldPayConfig.getInstance().get(WorldPayConfig.TEST_MODE);
        String installationId = WorldPayConfig.getInstance().get(WorldPayConfig.INSTALLATION_ID);
        String url = "";
        if(WorldPayConfig.getInstance().get(WorldPayConfig.ENVIRONMENT).equals("TEST")){
            url = WorldPayConfig.getInstance().get(WorldPayConfig.WORLDPAY_SANDBOX_URL);
        }
        else{
            url = WorldPayConfig.getInstance().get(WorldPayConfig.WORLDPAY_URL);
        }
        String signatureFields = currencyCode + ":" + amount + ":" + testMode + ":" + installationId;
        out.println(signatureFields);
    %>

 
    <body>

        <div class="mainBody">

            <div class="divtable"

                 <div class="row"><div class="cell">Submission URL: <%= url %></div></div>
                <br />

                <form name="paymentToken" method="post" action="<%= url %>">

                    <!-- Mandatory Parameters -->
                    <div class="row"><div class="cellLeft">Installation ID:</div><div class="cellRight"><input type="text" name="instId" value="<%= installationId %>"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Amount:</div><div class="cellRight"><input type="text" name="amount" value="<%= amount %>"/></div></div>
                    <br />	
                    <div class="row"><div class="cellLeft">CartID:</div><div class="cellRight"><input type="text" name="cartId" value="<%= WorldPayConfig.getInstance().get(WorldPayConfig.CART_PREFIX) %>cartId"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Currency:</div><div class="cellRight"><input type="text" name="currency" value="<%= currencyCode %>"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Test Mode:</div><div class="cellRight"><input type="text" name="testMode" value="<%= WorldPayConfig.getInstance().get(WorldPayConfig.TEST_MODE) %>"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Description:</div><div class="cellRight"><input type="text" name="desc" value="description of product"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Auth Mode:</div><div class="cellRight"><input type="text" name="authMode" value="<%= WorldPayConfig.getInstance().get(WorldPayConfig.AUTH_MODE) %>"/><%= WorldPayConfig.getInstance().get(WorldPayConfig.AUTH_MODE_ERROR) %></div></div>
                    <br />

                    <!-- Preferred Merchant Account -->
                    <div class="row"><div class="cellLeft">Account ID 1:</div><div class="cellRight"><input type="text" name="accId1" value="<%= WorldPayConfig.getInstance().get(WorldPayConfig.MARCHAT_CODE_1) %>"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Account ID 2:</div><div class="cellRight"><input type="text" name="accId1" value="<%= WorldPayConfig.getInstance().get(WorldPayConfig.MARCHAT_CODE_2) %>"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Account ID 3:</div><div class="cellRight"><input type="text" name="accId1" value="<%= WorldPayConfig.getInstance().get(WorldPayConfig.MARCHAT_CODE_3) %>"/></div></div>
                    <br />

                    <!-- Billing Address Details. By default it will be hidden -->
                    <!--<?php echo $billingDetails; ?>-->
                    <div class="row"><div class="cellLeft">Name:</div><div class="cellRight"><input type="text" name="name" value="Name"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Address 1:</div><div class="cellRight"><input type="text" name="address1" value="Address line 1"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Address 2:</div><div class="cellRight"><input type="text" name="address2" value="Address line 2"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Address 3:</div><div class="cellRight"><input type="text" name="address3" value="Address line 3"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Postcode:</div><div class="cellRight"><input type="text" name="postcode" value="Postcode"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Telephone:</div><div class="cellRight"><input type="text" name="tel" value="123456789"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Country:</div><div class="cellRight"><input type="text" name="country" value="GB"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Town:</div><div class="cellRight"><input type="text" name="town" value="Town"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Fax:</div><div class="cellRight"><input type="text" name="fax" value="123456789"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Email:</div><div class="cellRight"><input type="text" name="email" value="test@test.com"/></div></div>
                    <!--<br /><?php echo $billingClose; ?>-->
                    <!-- Delivery Address Details -->
                    <div class="row"><div class="cellLeft">With delivery</div><div class="cellRight"><input type="text" name="withDelivery" value="" /></div></div>
                    <br />
                    <!--<?php echo $deliveryDetails; ?>-->
                    <div class="row"><div class="cellLeft">Delivery Name:</div><div class="cellRight"><input type="text" name="delvName" value="Delivery Address line 1"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Delivery Address 1:</div><div class="cellRight"><input type="text" name="delvAddress1" value="Delivery Address line 1"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Delivery Address 2:</div><div class="cellRight"><input type="text" name="delvAddress2" value="Delivery Address line 2"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Delivery Address 3:</div><div class="cellRight"><input type="text" name="delvAddress3" value="Delivery Address line 3"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Delivery Postcode:</div><div class="cellRight"><input type="text" name="delvTown" value="Delivery Town"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Delivery Postcode:</div><div class="cellRight"><input type="text" name="delvPostcode" value="Delivery Postcode"/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Delivery Country:</div><div class="cellRight"><input type="text" name="delvCountry" value="GB"/></div></div>
                    <br />
                    <!--<?php echo $deliveryClose; ?>-->
                    <!-- Fix and Hide contact details -->
                    <div class="row"><div class="cellLeft">Fix Contact:</div><div class="cellRight"><input type="text" name="fixContact" value=""/></div></div>
                    <br />
                    <div class="row"><div class="cellLeft">Hide Contact:</div><div class="cellRight"><input type="text" name="hideContact" value=""/></div></div>
                    <br />
                    <!-- Signature Parameter - DO NOT CHANGE -->

                    <!--<?php echo $MD5open; ?><div class="row"><div class="cellLeft">MD5 Signature:</div><div class="cellRight"><input type="text" name="signature" value="<?php echo md5($MD5secretKey.":".$SignatureFields); ?>"/></div></div><?php echo $MD5close; ?>-->

                    <br/><br/>	

                    <div id="payButton" ><input type="submit" value="<%= WorldPayConfig.getInstance().get(WorldPayConfig.BUTTON_DISPLAY_TEXT) %>"/></div>
                </form>

            </div>
        </div>
        <br/>

        <div id="logoDisplay">
            <!-- Payment Methods Displayed -->
            <?php echo $displayVisa; ?>
            <?php echo $displayMastercard; ?>
            <?php echo $displayMaestro; ?>
            <?php echo $displayJCB; ?>
            <?php echo $displayAmex; ?>
            <?php echo $displayELV; ?>
        </div>

        <div id="wpLogo">
            <br />
            <!-- Powered by WorldPay logo-->
            <a href="http://www.worldpay.com/" target="_blank" title="Payment Processing - WorldPay - Opens in new browser window"><img src="http://www.worldpay.com/images/poweredByWorldPay.gif" border="0" alt="WorldPay Payments Processing"></a>
        </div>

    </body>
</html>
