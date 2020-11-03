<?php
function getinfo($db,$field1,$field2,$value){

    $v = "";

    $stmt = $db->prepare("SELECT ? as val FROM table1 WHERE ? = ? or id =?"); 
    $stmt->bind_param("ssss",$field1, $field2,".$value.",$_POST['id']);
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