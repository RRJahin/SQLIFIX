<?php
function getinfo($db,$field1,$field2,$value){

    $v = "";

    $query = $db->query("SELECT $field1 as val FROM table1 WHERE '$field2' != '".$value."' ");

    if ($query->num_rows() > 0){

      foreach ($query->result() as $row)

       {

         $v =  $row->val;

       }

   }

   

  return $v;

}

?>