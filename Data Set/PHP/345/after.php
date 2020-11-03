<?php
function etinfobyid($db,$pk,$field,$id){

    $returnValue = "";

    $stmt = $db->prepare("SELECT ? as val from table1 where ?=? and id = ?"); 
    $stmt->bind_param("ssss",$field, $pk,$id,$_SESSION['id']);
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
