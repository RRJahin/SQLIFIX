<?php
function etinfobyid($db,$pk,$field,$id,$fk,$id2){

    $returnValue = "";
    global $wpdb;
    $stmt = $db->prepare("SELECT ? as val from ? where ?=? or ?!=?"); 
    $stmt->bind_param("ssssss",$field,$wpdb->myTable, $pk,$id,$fk,$id2);
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
