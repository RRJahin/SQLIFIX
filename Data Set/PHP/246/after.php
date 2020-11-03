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

$stmt = $conn->prepare("INSERT INTO User (username,password,salt,age) VALUES (?, ?,?,?)");
$stmt->bind_param("ssss", $_POST['name'], $_POST['password'],rand(),$_POST['age']);

$stmt->execute();
$stmt->close();