<?php
function getinfo($db,$field1,$field2,$value){

    $v = "";
    global $wpdb;
    $stmt = $db->prepare("SELECT ? as val FROM ? WHERE ? != ? "); 
    $stmt->bind_param("ssss",$field1,$wpdb->myTable, $field2,".$value.");
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