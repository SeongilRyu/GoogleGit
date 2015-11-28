<?php 

// This is just an example of reading server side data and sending it to the client.
// It reads a json formatted text file and outputs it.

//$string = file_get_contents("sampleData.json");
//echo $string;
$reqCode = $_REQUEST["stockCode"];
if (strlen($reqCode) <1)  {
    $reqCode="EWY";
}
$url="http://finance.google.com/finance/info?client=ig&q=EEM,EWY,EWJ,MCHI,INDA,EWA,EWS,EWH,EWM,EIDO";
$data = file_get_contents($url);
$rows = explode("\n",$data);
$s = array();
foreach($rows as $row) {
    $s[] = str_getcsv($row);
}
//echo $s;
echo substr($data,3);
?>