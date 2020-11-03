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
$stmt = $conn->prepare("INSERT INTO User (username,password,salt,age,id) VALUES (?, ?,?,?,?)");
$stmt->bind_param("ssiis", $_POST['name'], $_POST['password'],rand(),$_POST['age'],$_SESSION['id']);

$stmt->execute();
$stmt->close();
