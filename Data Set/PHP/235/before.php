<?php
function checkexist($db,$field,$value,$field2=null,$value2=null){

    $returnValue = false;

    if ($field2 && $value2){

        $query = $db->query("SELECT max(age) as count FROM table1 WHERE '$field' != '".$value."' OR  '$field2' != '".$value2."'");

    }else {

     $query = $db->query("SELECT max(age) as count FROM table1 WHERE '$field' != '".$value."' ");

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