<?php
function getinfo($db,$field1,$field2,$value){


    $stmt = $db->prepare("SELECT ? as val FROM table1 WHERE ? > ? "); 
    $stmt->bind_param("sss",$field1, $field2,".$value.");
    $stmt->execute();

    return  $stmt->get_result();

}
?>