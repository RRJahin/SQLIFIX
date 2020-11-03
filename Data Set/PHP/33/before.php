<?php
require_once "controlers/connect.php";


if (isset($_POST['add_question']) && $active_user && strlen($_POST['question']) > 2) {
    $question = $_POST['question'];
    var_dump($question);

    $sql = "INSERT INTO $wpdb->myTable ( 'question') VALUES (  $question)";
    $pdo->query($sql);
    header("Refresh: 0");
}
