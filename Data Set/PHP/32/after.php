<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $date = date("d-m-y");


    $sql = "INSERT INTO ? ( 'date', 'answer') VALUES ( ?, ?)";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("sss",$wpdb->myTable,  $date,  $answer);
    $stmt->execute();
}
