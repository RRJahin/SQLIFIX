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
$email = $_POST['email'];
$stmt = $conn->prepare("SELECT * FROM myTable WHERE name= ? and email=?");
$stmt->bind_param("ss", $name,$email);

$stmt->execute();
$stmt->close();
