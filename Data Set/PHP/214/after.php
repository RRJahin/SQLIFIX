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

$stmt = $conn->prepare("DELETE FROM myTable WHERE id = ? AND ISACTIVE = FALSE");
$stmt->bind_param("i", $_SESSION['id']);
$stmt->execute();

$stmt->close();
$conn->close();