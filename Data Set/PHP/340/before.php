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

$conn->query("UPDATE myTable SET name = '{$_POST['name']}', pass={$_POST['pass']} WHERE id = '{$_SESSION['id']}'");

$conn->close();
