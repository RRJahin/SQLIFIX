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

$sql = "SELECT * FROM users WHERE id ='{$_SESSION['id']}' and isLogin = $isLogin";

$result = $conn->query($sql);
while ($row = $result->fetch_assoc()) {
    echo $row['name'];
}

$conn->close();