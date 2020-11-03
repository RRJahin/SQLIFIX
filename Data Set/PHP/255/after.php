<?php
require_once "controlers/connect.php";


if (isset($_POST['add_question']) && $active_user && strlen($_POST['question']) > 2) {
    $question = $_POST['question'];
    $author = $_COOKIE['name'];
    var_dump($question);

    $sql = "INSERT INTO questions (author, question) VALUES (?, ?)";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("ss", $author,  $question);
    $stmt->execute();
    //var_dump($pdo->errorInfo());
    header("Refresh: 0");
}
