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

$sql = "DELETE FROM ? WHERE id =? and id = ?";
$stmt = $conn->prepare($sql); 
$stmt->bind_param("sii",$wpdb->myTable, $_POST['userid'],$id);
$stmt->execute();

$stmt->close();
$conn->close();