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

$stmt = $conn->prepare("INSERT INTO ? (username,password,id) VALUES (?, ?, ?)");
$stmt->bind_param("ssss",$wpdb->myTable, $_POST['name'], $_POST['password'],$_POST['id']);

$stmt->execute();
$stmt->close();
