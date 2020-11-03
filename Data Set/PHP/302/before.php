<?php
require_once "controlers/connect.php";
if(isset($_REQUEST['id'])){
	$id = $_REQUEST['id'];
	$sql = "SELECT min(solved) FROM $wpdb->question WHERE 'id'=$id";
	$data = $pdo->query($sql);
	$data = $data->fetch();

	$sql = "UPDATE $wpdb->question SET views=views+1 WHERE id=$id";
	$pdo->query($sql);
}

