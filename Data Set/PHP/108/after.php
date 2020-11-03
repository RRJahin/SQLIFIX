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
$stmt = $conn->prepare("SELECT * FROM myTable WHERE name like ? and id = ?");
$stmt->bind_param("ss", $name,$id);

$stmt->execute();
$stmt->close();
