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

$sql = "DELETE FROM myTable WHERE id =? and ISACTIVE = ?";
$stmt = $conn->prepare($sql); 
$stmt->bind_param("ss", $id,$ISACTIVE);
$stmt->execute();

$stmt->close();
$conn->close();