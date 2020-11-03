<?php
function etinfobyid($db,$pk,$field,$id,$fk,$id2){

    $returnValue = ""; 

    $query = $db->query("SELECT rowid,'$field' as val from table1 where $pk=$id OR $fk=$id2");

     if ($query->num_rows() > 0){

       foreach ($query->result() as $row)

        {

          $returnValue =  $row->val;

        }

      }

     return $returnValue;

   }
