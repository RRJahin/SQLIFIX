<?php
function checkexist($db,$field,$value,$id,$field2=null,$value2=null){

    $returnValue = false;

    if ($field2 && $value2){

        $query = $db->query("SELECT count(*) as count FROM table1 WHERE '$field' != '".$value."' OR  '$field2' != '".$value2."' and id = $id");

    }else {

     $query = $db->query("SELECT count(*) as count FROM table1 WHERE '$field' != '".$value."' and id = $id");

    }  

     if ($query->num_rows() > 0){

       foreach ($query->result() as $row)

        {

          $count =  $row->count;

        }

    }

    if ($count > 0){

       $returnValue = true;   

    }

   return $returnValue;

   }
?>