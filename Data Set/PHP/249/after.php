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
    $stmt1 = $conn->prepare("INSERT INTO myTable (name) VALUES (?)");
    $stmt2 = $conn->prepare("UPDATE myTable SET email = ? WHERE id = ?");
    $stmt1->bind_param("s", $name);
    $stmt2->bind_param("ss", $email,$_SESSION['id']);
    $stmt1->execute();
    $stmt2->execute();
    $stmt1->close();
    $stmt2->close();
    
    $conn->autocommit(TRUE); //turn off transactions + commit queued queries
} catch (Exception $e) {
    $conn->rollback(); //remove all queries from queue if error (undo)
    throw $e;
}
$conn->close();
