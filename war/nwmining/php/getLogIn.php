<!DOCTYPE html>
<html>
<head>
    <script>
        function btnClose() {
            window.history.back();
            location.href = "../nwmineindex.html";
        }
    </script>
</head>
<body>
<p>Login Result:<br>
<?php
	echo "Log in 되었습니다.<br>";
    echo "Total Hash Rate: 888 Ths"
?>
	<button onclick="btnClose();">Close</button>
</body>
</html>