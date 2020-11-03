<?php
function etinfobyid($db,$pk,$field,$id){


    $stmt = $db->prepare("SELECT rowid,,? as val from table1 where ?!=?"); 
    $stmt->bind_param("sss",$field, $pk,$id);
    $stmt->execute();

    return $stmt->get_result();
  
}
