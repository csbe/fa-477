<?php

	$options = array('login'=>'buchs.enrico@gmail.com', 'password'=>'ownx70zk');
	
	$client = new SoapClient('http://test-e-service.fenceit.ch/ws-zefix-1.6/ZefixService?wsdl', $options);
	
	$body = array('name'=>'digitec6', 'active'=>true,'maxSize'=>5);	
	
	$result = $client->SearchByName($body);
	
	var_dump($result);
	
	?>