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
$stmt = $conn->prepare("SELECT uname FROM ? WHERE id = ?");
$stmt->bind_param("ss",$wpdb->usertable, $_SESSION['id']);
$stmt->execute();

$stmt = $conn->prepare("DELETE FROM ? WHERE id = ?");
$stmt->bind_param("ss",$wpdb->usertable, $_SESSION['id']);
$stmt->execute();

$stmt->close();
$conn->close();