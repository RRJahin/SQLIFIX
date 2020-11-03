<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $author = $_COOKIE['name'];
    $date = date("d-m-y");
    $question = $_GET['id'];


    $sql = "INSERT INTO 'answers' ('author', 'date', 'question', 'answer') VALUES (?, ?, ?, ?)";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("ssss", $author, $date, $question, $answer);
    $stmt->execute();
}
