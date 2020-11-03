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
$salt = 50;
$conn->query("INSERT INTO $wpdb->usertable (username,password,salt,age) VALUES ('{$_POST['name']}','{$_POST['password']}',$salt,'{$_POST['age']}')");

$conn->close();
?>