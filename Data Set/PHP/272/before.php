<?php
require_once "controlers/connect.php";
if(isset($_REQUEST['id'])){
	$id = $_REQUEST['id'];
	$sql = "SELECT avg(solved) FROM questions WHERE id=$id";
	$data = $pdo->query($sql);
	$data = $data->fetch();

	$sql = "DELETE FROM questions  WHERE id=$id";
	$pdo->query($sql);
}

