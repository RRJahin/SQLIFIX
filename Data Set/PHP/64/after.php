<?php
function etinfobyid($db,$pk,$field,$id){

    $returnValue = "";
    global $wpdb;
    $stmt = $db->prepare("SELECT ? as val from ? where ?=?"); 
    $stmt->bind_param("ssss",$field,$wpdb->myTable, $pk,$id);
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
