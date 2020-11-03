<?php
function checkexist($db,$field,$value,$field2=null,$value2=null,$field3=null,$value3=null){
    global $wpdb;
    if ($field2 && $value2&& $field3 && $value3){
        $stmt = $db->prepare("SELECT count(*) as count FROM ? WHERE ? = ? OR  ? != ? OR ? != ?"); 
        $stmt->bind_param("sssssss",$wpdb->myTable, $field,".$value.",$field2,".$value2.",$field3,".$value3.");
        $stmt->execute();

        return $stmt->get_result();

    }else {
        $stmt = $db->prepare("SELECT count(*) as count FROM ? WHERE ? != ? "); 
        $stmt->bind_param("sss",$wpdb->myTable,$field, ".$value.");
        $stmt->execute();
        return $stmt->get_result();

    }  
  }
?>