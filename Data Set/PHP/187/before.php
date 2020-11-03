<?php
function etinfobyid($db,$pk,$field,$id,$fk,$id2){

    $returnValue = ""; 
    global $wpdb;
    $query = $db->query("SELECT '$field' as val from $wpdb->myTable where $pk=$id OR $fk!=$id2");

     if ($query->num_rows() > 0){

       foreach ($query->result() as $row)

        {

          $returnValue =  $row->val;

        }

      }

     return $returnValue;

   }
