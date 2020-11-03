<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $author = $_COOKIE['name'];
    $question = $_GET['id'];


    $sql = "INSERT INTO $wpdb->myTable ('author', 'answer') VALUES ('$author', $answer)";
    $pdo->query($sql);
}
