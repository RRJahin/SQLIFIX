<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $author = $_COOKIE['name'];
    $question = $_GET['id'];


    $sql = "INSERT INTO 'answers' ('author',  'question', 'answer') VALUES ('$author', $question, $answer)";
    $pdo->query($sql);
}