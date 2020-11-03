<?php
function getinfo($db,$field1,$field2,$value){

    return $db->query("SELECT $field1 as val FROM table1 WHERE '$field2' <= '".$value."' ");

    

}

?>