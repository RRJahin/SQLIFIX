<?php
require_once "controlers/connect.php";
if(isset($_REQUEST['id'])){
	$id = $_REQUEST['id'];
	$sql = "SELECT * FROM 'questions' WHERE 'id'=$id";
	$data = $pdo->query($sql);
	$data = $data->fetch();

	$sql = "UPDATE 'questions' SET 'views'='views'+1 WHERE 'id'=$id";
	$pdo->query($sql);
}

