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
$stmt = $conn->prepare("SELECT id FROM myTable WHERE name not like ?");
$stmt->bind_param("s", $name);

$stmt->execute();
$stmt->close();
