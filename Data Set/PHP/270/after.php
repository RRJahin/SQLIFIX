<?php
function getbyattribute($db, $key, $value, $key2 = null, $value2 = null)
{

    if (($key2) && ($value2)) {

        $stmt = $db->prepare("SELECT uname FROM table1 where ? = ? AND ? != ?");
        $stmt->bind_param("ssss", $key, ".$value.", $key2, ".$value2.");
        $stmt->execute();
        return  $stmt->get_result();
    } else {

        $stmt = $db->prepare("SELECT uname FROM table1 where ? = ?");
        $stmt->bind_param("ss", $key, ".$value.");
        $stmt->execute();
        return  $stmt->get_result();
    }
}
