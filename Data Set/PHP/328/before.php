<?php
function getinfo($db,$field1,$field2,$value){

    global $wpdb;

    return $db->query("SELECT $field1 FROM $wpdb->usertable WHERE '$field2' != '".$value."' ");

    

}

?>