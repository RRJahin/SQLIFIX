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

$stmt = $conn->prepare("SELECT uname FROM ? WHERE name= ?");
$stmt->bind_param("ss", $wpdb->myTable,$_POST['name']);

$stmt->execute();
$stmt->close();
