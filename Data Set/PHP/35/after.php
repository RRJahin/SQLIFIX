<?php
require_once "controlers/connect.php";
if(isset($_REQUEST['id'])){
	$id = $_REQUEST['id'];
    $sql = "SELECT  max(solved) FROM ? WHERE 'id'=?";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("ss",$wpdb->myTable, $id);
    $stmt->execute();
	$data = $stmt->get_result();
	$data = $data->fetch();

	$sql = "DELETE FROM ? WHERE 'id'=?";
	$stmt = $pdo->prepare($sql);
    $stmt->bind_param("ss",$wpdb->myTable, $id);
    $stmt->execute();
}

