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
$name = $_POST['name'];
$stmt = $conn->prepare("UPDATE ? SET name = ?, isLogin = ? WHERE id = ?");
$stmt->bind_param("ssss",$wpdb->myTable, $name,$isLogin, $_SESSION['id']);
$stmt->execute();

$stmt->close();
$conn->close();