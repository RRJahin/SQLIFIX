<?php
function etinfobyid($db,$pk,$field,$id){
    global $wpdb;

    $stmt = $db->prepare("SELECT ? as val from ? where ?=?"); 
    $stmt->bind_param("ssss",$field,$wpdb->usertable, $pk,$id);
    $stmt->execute();

    return $stmt->get_result();
  
}
