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
$pass = password_hash($_POST['password'], 1);
$stmt = $conn->prepare("INSERT INTO ? (username,password,salt,age) VALUES (?, ?, ?,?)");
$stmt->bind_param("sssii",$wpdb->user, $_POST['name'], $pass,rand(),$_POST['age']);

$stmt->execute();
$stmt->close();
