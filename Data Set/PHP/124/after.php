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

$stmt = $conn->prepare("SELECT max(age) FROM myTable WHERE name= ? and id=?");
$stmt->bind_param("ss", $_POST['name'],$id);

$stmt->execute();
$stmt->close();
