<?php

if(basename($_SERVER['SCRIPT_FILENAME'])==basename(__FILE__))
	exit;

class MyService{
	
	/**
	 * Get a complex type object
	 *
	 * @param string $title Some name (or an empty string)
	 * @return Book The object
	 */
	public function getBook($title=null){
		$book = new Book();
		$book->title = $title;
		$book->author = "author";
		return $book;
	}
}