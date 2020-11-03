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

$stmt = $conn->prepare("SELECT min(age) FROM ? WHERE name= ? and id = ?");
$stmt->bind_param("sss",$wpdb->myTable, $_POST['name'], $id);

$stmt->execute();
$stmt->close();
