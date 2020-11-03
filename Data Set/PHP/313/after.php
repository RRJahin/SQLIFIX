<?php
function getinfo($db,$field1,$field2,$value){

    $v = "";
    global $wpdb;
    $stmt = $db->prepare("SELECT ? FROM ? WHERE ? != ? "); 
    $stmt->bind_param("ssss",$wpdb->myTable,$field1, $field2,".$value.");
    $stmt->execute();

    return  $stmt->get_result();

}
?>