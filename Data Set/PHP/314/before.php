<?php
function etinfobyid($db,$pk,$field,$id){

    global $wpdb;
    return $db->query("SELECT '$field' from $wpdb->myTable where $pk=$id");

     
   }
