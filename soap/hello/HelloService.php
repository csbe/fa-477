<?php

$server = new SoapServer("http://localhost/ifa/soap/hello/HelloService.wsdl", array('uri'=>'http://localhost/ifa/soap/hello/', 'version'=>SOAP_1_2));


include 'Example.php';
class Service{
	public function sayHello($firstName){
		$arr = array("value",$firstName,"test"=>"wert");
		return $arr;	
	}
	
	public function sayVelo($firstName){
		$el = new Example();
		$el->alter = 33;
		$el->name = $firstName;
		$el->email = "ata@era";
		return $el;	
	}
}

$server->setObject(new Service());
$server->handle();
