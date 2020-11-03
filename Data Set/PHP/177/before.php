<?php
require_once "controlers/connect.php";
if(isset($_REQUEST['id'])){
	$id = $_REQUEST['id'];
	$sql = "SELECT * FROM $wpdb->myTable WHERE 'id'=$id";
	$data = $pdo->query($sql);
	$data = $data->fetch();

	$sql = "UPDATE $wpdb->myTable SET 'views'='views'+1 WHERE 'id'=$id and session_id = {$_POST['id']}";
	$pdo->query($sql);
}

