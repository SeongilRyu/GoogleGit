<?php

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
    <script>
        function btnClose() {
            window.history.back();
            location.href = "../nwmineindex.html";
        }
    </script>
        <title></title>
    </head>
    <body>
        Welcome <?php echo $_GET["username"]; ?><br>
        Your email address is: <?php echo $_GET["email"]; ?><br>
        Your password is: <?php echo $_GET["password"]; ?><br>
        Your country is: <?php echo $_GET["country"]; ?><br>
        Your payback BTC wallet address is: <?php echo $_GET["paybackBtcWallet"]; ?><br>
        <button onclick="btnClose();">Close</button>
    </body>
</html>
