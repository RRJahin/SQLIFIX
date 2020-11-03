<?php
function etinfobyid($db,$pk,$field,$id){


    return $db->query("SELECT rowid,'$field' as val from table1 where $pk!=$id");

     
   }
