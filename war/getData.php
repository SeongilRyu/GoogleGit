<?php 

// This is just an example of reading server side data and sending it to the client.
// It reads a json formatted text file and outputs it.

//$string = file_get_contents("sampleData.json");
//echo $string;
$reqCode = $_REQUEST["stockCode"];
if (strlen($reqCode) <1)  {
    $reqCode="EWY";
}
$url="http://www.google.com/finance/historical?q=NYSEARCA%3A" . $reqCode ."&ei=cf86VanCK5D6uAToo4D4AQ&output=csv";
$data = file_get_contents($url);
$rows = explode("\n",$data);
$s = array();
foreach($rows as $row) {
    $s[] = str_getcsv($row);
}
//echo $s;
echo $data;
?>