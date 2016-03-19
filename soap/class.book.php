<?php

if(basename($_SERVER['SCRIPT_FILENAME'])==basename(__FILE__))
	exit;

/**
 * This is how to define a complex type f.e. - the class Book doesn't need to exists, 
 * but it would make it easier for you to return that complex type from a method
 *
 * @pw_element string $title A string with the title
 * @pw_element string $author A string with the author name
 * @pw_complex Book The complex type name definition
 */
class Book {
    public $title;
    public $author;
}

?>