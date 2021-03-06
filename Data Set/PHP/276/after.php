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

// prepare and bind
$sql = "INSERT INTO ? (firstname, lastname, email) VALUES (?, ?, select email from user where firstname = ? and lastname=?)";
$stmt = $conn->prepare($sql);
$stmt->bind_param("sssss",$wpdb->geust, "John", "Doe", "john@example.com", "John", "Doe");

if ($stmt->execute() === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$stmt->close();
$conn->close();
?>