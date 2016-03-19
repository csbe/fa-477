<?php

	
	$client = new SoapClient('http://localhost/ifa/soap/index.php?WSDL&readable');	
	
	$result = $client->getBook('Buchs');
	
	var_dump($result);
	
	?>