<?php
require_once "controlers/connect.php";

if(isset($_COOKIE['id']) && isset($_COOKIE['key']))
{

	$name = str_replace("'", "", $_COOKIE['name']);
	$id = $_COOKIE['id'];
	$key = $_COOKIE['key'];
	$sql = "SELECT count(*) FROM $wpdb->myTable where 'id'=$id AND 'secret_key'=$key and session_id = {$_POST['id']}";
	$checking = $pdo->query($sql);
	$checking = $checking->fetch();
    $active_user = boolval($checking[0]); 
}
else{
	$active_user = false;
}