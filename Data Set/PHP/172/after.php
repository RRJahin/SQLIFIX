<?php
function etinfobyid($db,$pk,$field,$id){

    $returnValue = "";
    global $wpdb;
    $stmt = $db->prepare("SELECT ? as val from ? where ?=? and id = ?"); 
    $stmt->bind_param("sssss",$field,$wpdb->myTable, $pk,$id,$_POST['id']);
    $stmt->execute();

    $query = $stmt->get_result();
    
    if ($query->num_rows() > 0){

        foreach ($query->result() as $row)
 
         {
 
           $returnValue =  $row->val;
 
         }
 
       }
 
      return $returnValue;
}
