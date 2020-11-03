<?php
function getinfo($db,$field1,$field2,$value){

    $v = "";
    global $wpdb;
    $stmt = $db->prepare("SELECT ? as val FROM ?s WHERE ? <= ? "); 
    $stmt->bind_param("ssss",$field1,$wpdb->myTable, $field2,".$value.");
    $stmt->execute();

    return  $stmt->get_result();

}
?>