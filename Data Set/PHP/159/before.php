<?php
require_once "controlers/connect.php";


if (isset($_POST['add_answer']) && $active_user && strlen($_POST['answer']) > 2) {
    $answer = $_POST['answer'];
    $date = date("d-m-y");


    $sql = "INSERT INTO 'answers' ( 'date', 'answer') VALUES ( '$date', $answer)";
    $pdo->query($sql);
}
