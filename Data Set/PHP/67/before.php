<?php
require_once "controlers/connect.php";


if (isset($_POST['add_question']) && $active_user && strlen($_POST['question']) > 2) {
    $question = $_POST['question'];
    $author = $_COOKIE['name'];
    $date = date("d-m-y");
    var_dump($question);

    $sql = "INSERT INTO $wpdb->question ('author', 'date', 'question') VALUES ('$author', '$date', $question)";
    $pdo->query($sql);
    //var_dump($pdo->errorInfo());
    header("Refresh: 0");
}
