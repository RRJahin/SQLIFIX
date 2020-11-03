<?php
function checkexist($db,$field,$value,$field2=null,$value2=null,$field3=null,$value3=null){

    global $wpdb;
    if ($field2 && $value2 && $field3 && $value3){

    return    $db->query("SELECT count(*) as count FROM $wpdb->myTable WHERE '$field' = '".$value."' OR  '$field2' != '".$value2."' or '$field3' != '".$value3."");

    }else {

     return $db->query("SELECT count(*) as count FROM $wpdb->myTable WHERE '$field' != '".$value."' ");

    }  

   }
