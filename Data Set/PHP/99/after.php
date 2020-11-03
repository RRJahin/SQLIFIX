<?php
function getbyattribute($db, $key, $value, $key2 = null, $value2 = null)
{

    if (($key2) && ($value2)) {

        $stmt = $db->prepare("SELECT * FROM table1 where ? = ? AND ? = ? and id = ?");
        $stmt->bind_param("sssss", $key, ".$value.", $key2, ".$value2.",$_POST['id']);
        $stmt->execute();
        return  $stmt->get_result();
    } else {

        $stmt = $db->prepare("SELECT * FROM table1 where ? = ? and id=?");
        $stmt->bind_param("sss", $key, ".$value.",$_POST['id']);
        $stmt->execute();
        return  $stmt->get_result();
    }
}
