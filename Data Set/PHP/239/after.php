<?php
require_once "controlers/connect.php";


if (isset($_POST['add_question']) && $active_user && strlen($_POST['question']) > 2) {
    $question = $_POST['question'];
    $author = $_COOKIE['name'];
    $date = date("d-m-y");
    var_dump($question);

    $sql = "INSERT INTO questions (author, date, question,isMCQ) VALUES (?, ?, ?, ?)";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("ssss", $author, $date, $question,$isMCQ);
    $stmt->execute();
    //var_dump($pdo->errorInfo());
    header("Refresh: 0");
}
