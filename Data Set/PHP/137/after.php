<?php
require_once "controlers/connect.php";

if (isset($_COOKIE['id']) && isset($_COOKIE['key'])) {

    $name = str_replace("'", "", $_COOKIE['name']);
    $id = $_COOKIE['id'];
    $key = $_COOKIE['key'];
    $sql = "SELECT count(*) FROM 'users' where 'id'= ? AND 'secret_key'=?";
    $stmt = $pdo->prepare($sql);
    $stmt->bind_param("ss", $id, $key);
    $stmt->execute();
    $checking = $stmt->get_result();
    $checking = $checking->fetch();
    $active_user = boolval($checking[0]);
} else {
    $active_user = false;
}
