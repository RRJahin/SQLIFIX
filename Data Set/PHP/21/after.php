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
$id = $_POST['id'];
$stmt = $conn->prepare("SELECT * FROM ? WHERE name like ? AND id=?");
$stmt->bind_param("ssi",$wpdb->myTable, $name,$id);

$stmt->execute();
$stmt->close();
