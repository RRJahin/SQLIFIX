<?php
require_once "controlers/connect.php";
if(isset($_REQUEST['id'])){
	$id = $_REQUEST['id'];
    $sql = "SELECT  min(solved) FROM 'questions' WHERE 'id'=?";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("s", $id);
    $stmt->execute();
	$data = $stmt->get_result();
	$data = $data->fetch();

	$sql = "UPDATE 'questions' SET 'views'='views'+1 WHERE 'id'=? and session_id = ?";
	$stmt = $pdo->prepare($sql);
    $stmt->bind_param("ss", $id,$id);
    $stmt->execute();
}

