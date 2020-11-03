<?php
function getbyattribute($db, $key, $value, $key2 = null, $value2 = null)
{
    global $wpdb;
    if (($key2) && ($value2)) {

        $stmt = $db->prepare("SELECT uname FROM ? where ? != ? AND ? != ?");
        $stmt->bind_param("sssss",$wpdb->myTable,$key, ".$value.", $key2, ".$value2.");
        $stmt->execute();
        return  $stmt->get_result();
    } else {

        $stmt = $db->prepare("SELECT uname FROM ? where ? != ?");
        $stmt->bind_param("sss",$wpdb->myTable, $key, ".$value.");
        $stmt->execute();
        return  $stmt->get_result();
    }
}
