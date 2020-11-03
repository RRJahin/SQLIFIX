<?php
function checkexist($db,$field,$value,$field2=null,$value2=null){

    $returnValue = false;
    global $wpdb;
    if ($field2 && $value2){

        $query = $db->query("SELECT count(*) as count FROM $wpdb->myTable WHERE '$field' = '".$value."' AND  '$field2' = '".$value2."'");

    }else {

     $query = $db->query("SELECT count(*) as count FROM $wpdb->myTable WHERE '$field' = '".$value."' ");

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