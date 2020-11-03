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

$stmt = $conn->prepare("DELETE FROM myTable WHERE id = ? or email=?");
$stmt->bind_param("is", $_SESSION['id'],$_POST['email']);
$stmt->execute();

$stmt->close();
$conn->close();