<?php
   header('Content-Type: application/json');
/*
 * Following code will delete a product from table
 * A product is identified by product id (pid)
 */
 
// usage : http://localhost/tp2/delete_product.php?pid=4 
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_GET['id_conge'])) {
    $id_conge = $_GET['id_conge'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    $con = $db->connect();
    
    // mysql update row with matched pid
    $result = $con->query("DELETE FROM $wpdb->myTable WHERE id_conge != $id_conge and id = $id");
         
    // check if row deleted or not
 //   if (mysqli_affected_rows() > 0) {
 
    if ($result > 0) {   
       // successfully updated
        $response["success"] = 1;
        $response["message"] = "Conge successfully deleted";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No conge found";
		$response["error"] = $con -> error;
 
        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
