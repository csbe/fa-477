<?php
ini_set("soap.wsdl_cache_enabled", 0);

$server = new SoapServer(null, array('uri'=>'http://localhost/ifa/soap/', 'version'=>SOAP_1_2));

class Test{
function test() {
	return "test";
}
}

$server->setObject(new Test());
$server->handle();

var_dump($server);

