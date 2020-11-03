<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $author = $_COOKIE['name'];
    $date = date("d-m-y");
    $question = $_GET['id'];


    $sql = "INSERT INTO $wpdb->myTable1 ('author', 'date', 'question', 'answer') VALUES ('$author', '$date', $question, $answer)";
    $pdo->query($sql);

    $sql = "UPDATE $wpdb->myTable2 SET 'answers'='answers'+1 WHERE 'id'=$question ans session_id = {$_POST['id']}" ;
    $pdo->query($sql);
    //var_dump($pdo->errorInfo());
    header("Refresh: 0");
}
