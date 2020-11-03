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

try {
    $conn->autocommit(FALSE); //turn on transactions
    $name = $_POST['name'];
    $conn->query("INSERT INTO myTable (name) VALUES ('$name')");
    $conn->query("UPDATE myTable SET email = '$email' WHERE id = '{$_SESSION['id']}'");

    $conn->autocommit(TRUE); //turn off transactions + commit queued queries
} catch (Exception $e) {
    $conn->rollback(); //remove all queries from queue if error (undo)
    throw $e;
}
$conn->close();
