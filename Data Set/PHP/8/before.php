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
$pass = password_hash($_POST['password'],1);
$salt = 50;
$conn->query("INSERT INTO $wpdb->myTable (username,password,salt) VALUES ('{$_POST['name']}','$pass',$salt)");

$conn->close();
