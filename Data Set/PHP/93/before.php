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

$conn->query("INSERT INTO User (username,password,id) VALUES ('{$_POST['name']}','{$_POST['password']}','{$_POST['id']}')");

$conn->close();
?>