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
$pass = password_hash($_SESSION['password'], 1);
$stmt = $conn->prepare("INSERT INTO ? (username,password) VALUES (?, ?)");
$stmt->bind_param("sss",$wpdb->User, $_SESSION['name'], $pass);

$stmt->execute();
$stmt->close();
