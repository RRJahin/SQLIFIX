<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$stmt = $conn->prepare("DELETE FROM ? WHERE id = ? AND isLogin = TRUE");
$stmt->bind_param("si",$wpdb->myTable, $_SESSION['id']);
$stmt->execute();

$stmt->close();
$conn->close();