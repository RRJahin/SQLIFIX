<?php
function getinfo($db,$field1,$field2,$value){

    $v = "";

    $stmt = $db->prepare("SELECT ? as val FROM table1 WHERE ? != ? "); 
    $stmt->bind_param("sss",$field1, $field2,".$value.");
    $stmt->execute();

    $query = $stmt->get_result();
    if ($query->num_rows() > 0){

        foreach ($query->result() as $row)
  
         {
  
           $v =  $row->val;
  
         }
  
     }
  
     
  
    return $v;
}
?>