<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $author = $_COOKIE['name'];
    $date = date("d-m-y");
    $question = $_GET['id'];


    $sql = "INSERT INTO ? ('author', 'date', 'question', 'answer') VALUES (?, ?, ?, ?)";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("sssss",$wpdb->myTable1, $author, $date, $question, $answer);
    $stmt->execute();

    $sql = "UPDATE ? SET 'answers'='answers'+1 WHERE 'id'=? and session_id = ?";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("sss",$wpdb->myTable2, $question,$_POST['id']);
    $stmt->execute();

    //var_dump($pdo->errorInfo());
    header("Refresh: 0");
}
