<?php
function checkexist($db,$field,$value,$field2=null,$value2=null){


    if ($field2 && $value2){

    return    $db->query("SELECT count(*) as count FROM table1 WHERE '$field' != '".$value."' OR  '$field2' = '".$value2."'");

    }else {

     return $db->query("SELECT count(*) as count FROM table1 WHERE '$field' != '".$value."' ");

    }  

   }
