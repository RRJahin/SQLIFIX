<?php
function etinfobyid($db,$pk,$field,$id){

    $returnValue = "";

    $stmt = $db->prepare("SELECT ? as val from table1 where ?<>?"); 
    $stmt->bind_param("sss",$field, $pk,$id);
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
