<?php
function etinfobyid($db,$pk,$field,$id){

    $returnValue = ""; 
    global $wpdb;
    $query = $db->query("SELECT '$field' as val from $wpdb->myTable where $pk=$id");

     if ($query->num_rows() > 0){

       foreach ($query->result() as $row)

        {

          $returnValue =  $row->val;

        }

      }

     return $returnValue;

   }
