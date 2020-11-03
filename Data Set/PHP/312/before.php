<?php
function checkexist($db,$field,$value,$field2=null,$value2=null){
    global $wpdb;

    if ($field2 && $value2){

    return    $db->query("SELECT sum(salary) as count FROM $wpdb->myTable WHERE '$field' != '".$value."' OR  '$field2' != '".$value2."'");

    }else {

     return $db->query("SELECT sum(salary) as count FROM $wpdb->myTable WHERE '$field' != '".$value."' ");

    }  

   }
