<?php
function checkexist($db,$field,$value,$field2=null,$value2=null){
    global $wpdb;

    if ($field2 && $value2){
        $stmt = $db->prepare("SELECT count(*) FROM ? WHERE ? != ? OR  ? != ?"); 
        $stmt->bind_param("sssss",$wpdb->usertable, $field,".$value.",$field2,".$value2.");
        $stmt->execute();

        return $stmt->get_result();

    }else {
        $stmt = $db->prepare("SELECT count(*) FROM ? WHERE ? != ? "); 
        $stmt->bind_param("sss",$wpdb->usertable,$field, ".$value.");
        $stmt->execute();
        return $stmt->get_result();

    }  
  }
?>