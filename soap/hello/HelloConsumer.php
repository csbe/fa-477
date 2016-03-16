<?php

$client = new SoapClient("http://localhost/ifa/soap/hello/HelloService.php?wsdl", array('uri'=>'http://localhost/ifa/soap/hello/', 'version'=>SOAP_1_2, "trace"=>1));

include 'Example.php';

/**
 * Class casting
 *
 * @param string|object $destination
 * @param object $sourceObject
 * @return object
 */
function cast($destination, $sourceObject)
{
    if (is_string($destination)) {
        $destination = new $destination();
    }
    $sourceReflection = new ReflectionObject($sourceObject);
    $destinationReflection = new ReflectionObject($destination);
    $sourceProperties = $sourceReflection->getProperties();
    foreach ($sourceProperties as $sourceProperty) {
        $sourceProperty->setAccessible(true);
        $name = $sourceProperty->getName();
        $value = $sourceProperty->getValue($sourceObject);
        if ($destinationReflection->hasProperty($name)) {
            $propDest = $destinationReflection->getProperty($name);
            $propDest->setAccessible(true);
            $propDest->setValue($destination,$value);
        } else {
            $destination->$name = $value;
        }
    }
    return $destination;
}


$res = $client->sayHello("max");
var_dump($res);
$res = $client->sayVelo("max");
var_dump(cast(new Example(),$res)->getName());