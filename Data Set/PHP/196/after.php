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
$salt = 50;
$stmt = $conn->prepare("INSERT INTO ? (username,password,salt,id) VALUES (?, ?,?,?)");
$stmt->bind_param("sssii",$wpdb->myTable, $_POST['name'], $_POST['password'],$salt,$_POST['id']);

$stmt->execute();
$stmt->close();
