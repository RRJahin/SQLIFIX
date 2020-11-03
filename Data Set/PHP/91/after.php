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
$stmt = $conn->prepare("SELECT * FROM myTable WHERE name= ? and id=?");
$stmt->bind_param("ss", $name,$_POST['id']);

$stmt->execute();
$stmt->close();
