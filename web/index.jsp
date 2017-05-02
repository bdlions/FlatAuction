<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="RequestServlet" method="POST" enctype="application/json">
            <textarea rows="10" cols="50" name="packetHeader">{"action":"1002","requestType":"1","sessionId":"sessionId-111"}</textarea>
            <br/>
            <textarea rows="10" cols="50" name="packetBody">{"fndId":"100"}</textarea>
            <br/>
            <input type="submit" name="submit" value="Request"/>
        </form>
    </body>
</html>
