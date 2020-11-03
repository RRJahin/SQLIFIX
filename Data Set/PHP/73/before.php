<?php
function getinfo($db,$field1,$field2,$value){

    $v = "";
    global $wpdb;
    return $db->query("SELECT $field1 as val FROM $wpdb->myTable WHERE '$field2' != '".$value."' ");

    

}

?>