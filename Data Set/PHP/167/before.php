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

$sql = "SELECT * FROM $wpdb->myTable WHERE id= $id and email = {$_POST['email']}";

$result = $conn->query($sql);
while ($row = $result->fetch_assoc()) {
    echo $row['name'];
}

$conn->close();
