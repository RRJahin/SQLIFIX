<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $author = $_COOKIE['name'];
    $date = date("d-m-y");
    $question = $_GET['id'];


    $sql = "INSERT INTO $wpdb->answer ('author', 'date', 'question', 'answer') VALUES ('$author', '$date', $question, $answer)";
    $pdo->query($sql);

    $sql = "UPDATE $wpdb->question SET 'answers'='answers'+1 WHERE 'id'=$question";
    $pdo->query($sql);
    //var_dump($pdo->errorInfo());
    header("Refresh: 0");
}