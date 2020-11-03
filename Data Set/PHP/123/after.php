<?php
function checkexist($db,$field,$value,$field2=null,$value2=null,$field3=null,$value3=null){

    if ($field2 && $value2&& $field3 && $value3){
        $stmt = $db->prepare("SELECT count(*) as count FROM table1 WHERE ? != ? OR  ? != ? OR ? != ?"); 
        $stmt->bind_param("ssssss", $field,".$value.",$field2,".$value2.",$field3,".$value3.");
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