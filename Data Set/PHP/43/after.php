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

$stmt = $conn->prepare("UPDATE myTable SET name = ? WHERE id = ?");
$stmt->bind_param("si", $_POST['name'], $_SESSION['id']);
$stmt->execute();

$stmt->close();
$conn->close();