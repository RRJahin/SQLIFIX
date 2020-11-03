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

$conn->query("UPDATE $wpdb->myTable SET name = '{$_POST['name']}', isLogin = TRUE WHERE id = '{$_SESSION['id']}' and email = $email");

$conn->close();
