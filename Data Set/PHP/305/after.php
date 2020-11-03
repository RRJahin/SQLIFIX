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
$age = $_POST['age'];
$stmt = $conn->prepare("SELECT * FROM ? WHERE name like ? AND age>=?");
$stmt->bind_param("ssi",$wpdb->myTable, $name,$age);

$stmt->execute();
$stmt->close();
