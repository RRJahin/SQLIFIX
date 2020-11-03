<?php
function getinfo($db,$field1,$field2,$value){

    global $wpdb;

    $stmt = $db->prepare("SELECT ?  FROM ? WHERE ? != ? "); 
    $stmt->bind_param("ssss",$field1, $wpdb->usertable,$field2,".$value.");
    $stmt->execute();

    return  $stmt->get_result();

}
?>