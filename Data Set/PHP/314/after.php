<?php
function etinfobyid($db,$pk,$field,$id){

    global $wpdb;
    $stmt = $db->prepare("SELECT ?  from ? where ?=?"); 
    $stmt->bind_param("ssss",$field,$wpdb->myTable, $pk,$id);
    $stmt->execute();

    return $stmt->get_result();
  
}
