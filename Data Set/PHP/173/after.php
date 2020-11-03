<?php
function getbyattribute($db, $key, $value, $key2 = null, $value2 = null)
{
    global $wpdb;
    if (($key2) && ($value2)) {

        $stmt = $db->prepare("SELECT * FROM ? where ? = ? AND ? = ? and id = ?");
        $stmt->bind_param("ssssss", $wpdb->myTable,$key, ".$value.", $key2, ".$value2.",$_POST['id']);
        $stmt->execute();
        return  $stmt->get_result();
    } else {

        $stmt = $db->prepare("SELECT * FROM ? where ? = ? and id=?");
        $stmt->bind_param("ssss",$wpdb->myTable, $key, ".$value.",$_POST['id']);
        $stmt->execute();
        return  $stmt->get_result();
    }
}
