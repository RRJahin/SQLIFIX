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
$stmt = $conn->prepare("UPDATE myTable SET name = ?, isLogin = FALSE WHERE id = ?");
$stmt->bind_param("si", $name, $_SESSION['id']);
$stmt->execute();

$stmt->close();
$conn->close();