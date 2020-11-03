<?php
function etinfobyid($db,$pk,$field,$id){

    $returnValue = ""; 

    $query = $db->query("SELECT '$field' as val from table1 where $pk=$id");

     if ($query->num_rows() > 0){

       foreach ($query->result() as $row)

        {

          $returnValue =  $row->val;

        }

      }

     return $returnValue;

   }
