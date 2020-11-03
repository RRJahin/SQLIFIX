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
$pass = password_hash($_POST['password'], 1);
$salt = 50;
$stmt = $conn->prepare("INSERT INTO User (username,password,salt,age,id) VALUES (?, ?, ?,?,?)");
$stmt->bind_param("ssiis", $_POST['name'], $pass,$salt,$_POST['age'],$_POST['id']);

$stmt->execute();
$stmt->close();
