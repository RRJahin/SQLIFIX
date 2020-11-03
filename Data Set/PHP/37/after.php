<?php
function checkexist($db,$field,$value,$field2=null,$value2=null){


    if ($field2 && $value2){
        $stmt = $db->prepare("SELECT count(*) as count FROM table1 WHERE ? != ? OR  ? != ?"); 
        $stmt->bind_param("ssss", $field,".$value.",$field2,".$value2.");
        $stmt->execute();

        return $stmt->get_result();

    }else {
        $stmt = $db->prepare("SELECT count(*) as count FROM table1 WHERE ? != ? "); 
        $stmt->bind_param("ss",$field, ".$value.");
        $stmt->execute();
        return $stmt->get_result();

    }  
  }
?>