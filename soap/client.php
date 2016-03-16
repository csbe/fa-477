<?php

ini_set("soap.wsdl_cache_enabled", 0);

$client = new SoapClient(null, array('location'=>'http://localhost/ifa/soap/',
'uri'=>'service.php', 'version'=>SOAP_1_2));

var_dump($client->test());