<?php
require_once "controlers/connect.php";


if (isset($_POST['add_question']) && $active_user && strlen($_POST['question']) > 2) {
    $question = $_POST['question'];
    var_dump($question);

    $sql = "INSERT INTO ? ('question') VALUES ( ?)";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("ss", $wpdb->myTable,  $question);
    $stmt->execute();
    //var_dump($pdo->errorInfo());
    header("Refresh: 0");
}
