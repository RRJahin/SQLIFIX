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
$conn->query("UPDATE $wpdb->usertable SET name = '$name' WHERE id = '{$_SESSION['id']}'");

$conn->close();
