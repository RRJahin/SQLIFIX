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
$conn->query("SELECT uname FROM $wpdb->usertable WHERE id = '{$_SESSION['id']}'");
$conn->query("DELETE FROM $wpdb->usertable WHERE id = '{$_SESSION['id']}'");

$conn->close();
