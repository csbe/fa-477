<?php
include 'ExampleInterface.php';

class Example implements ExampleInterface{ 
	
	public $alter;
	public $name;
	public $email;

	public function getName(){
		return $this->name;	
	}

}