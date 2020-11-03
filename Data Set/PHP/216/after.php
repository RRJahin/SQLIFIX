<?php
function etinfobyid($db,$pk,$field,$id,$fk,$id2){

    $returnValue = "";

    $stmt = $db->prepare("SELECT ? as val from table1 where ?=? or ?=?"); 
    $stmt->bind_param("sssss",$field, $pk,$id,$fk,$id2);
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
