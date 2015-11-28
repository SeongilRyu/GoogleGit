<?php
//if ("get"=="get") {
//     echo "do or not to?<br>";
//     echo "Total Hash Rate: php 441 hash";

//     $handle = fopen("http://pbmining.com/", "rb");
//     $contents = '';
//     while (!feof($handle)) {
//       $contents .= fread($handle, 8192);
//     }
//     fclose($handle);
//     echo $contents;



/**
} else {
***/

    $req = new HttpRequest('http://pbmining.com', HTTP_METH_GET);
    //$req->setContentType = 'Content-Type: text/html';
    //$req->setOptions(array('lastmodified' => filemtime('local.rss')));
    //$req->addQueryData(array('category' => 3));
    try {
        $req->send();
        if ($req->getResponseCode() == 200) {
            $res=$req->getResponseBody();
            echo $res;
        }
    } catch (HttpException $ex) {
        echo $ex;
    }
    echo "no response";    
/****
} else {
    //POST method
    $r = new HttpRequest('http://pbmining.com', HttpRequest::METH_POST);
    $r->setOptions(array('cookies' => array('lang' => 'de')));
    $r->addPostFields(array('user' => 'mike', 'pass' => 's3c|r3t'));
    $r->addPostFile('image', 'profile.jpg', 'image/jpeg');
    try {
        echo $r->send()->getBody();
    } catch (HttpException $ex) {
        echo $ex;
    }
}
***/

?>
