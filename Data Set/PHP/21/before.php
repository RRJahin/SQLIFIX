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
$id = $_POST['id'];
$conn->query("SELECT * FROM $wpdb->myTable WHERE name like '$name' AND id=$id");

$conn->close();
