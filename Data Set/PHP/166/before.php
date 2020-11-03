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
    $conn->query("INSERT INTO $wpdb->myTable(name, age,id) VALUES ('{$_POST['name']}', '{$_POST['age']}','{$_POST['id']}')");
    $conn->query("UPDATE $wpdb->myTable SET name = '{$_POST['name']}' WHERE age = '{$_POST['age']}' and id = '{$_POST['id']}'");

    $conn->autocommit(TRUE); //turn off transactions + commit queued queries
} catch (Exception $e) {
    $conn->rollback(); //remove all queries from queue if error (undo)
    throw $e;
}
$conn->close();
