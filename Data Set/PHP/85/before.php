<?php
function etinfobyid($db,$pk,$field,$id){
    global $wpdb;

    return $db->query("SELECT '$field' as val from $wpdb->usertable where $pk=$id");

     
   }
