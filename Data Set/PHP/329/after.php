<?php
function getbyattribute($db, $key, $value, $key2 = null, $value2 = null)
{
    global $wpdb;
    if (($key2) && ($value2)) {

        $stmt = $db->prepare("SELECT * FROM ? where ? = ? AND ? = ?");
        $stmt->bind_param("sssss", $wpdb->usertable,$key, ".$value.", $key2, ".$value2.");
        $stmt->execute();
        return  $stmt->get_result();
    } else {

        $stmt = $db->prepare("SELECT * FROM ? where ? = ?");
        $stmt->bind_param("sss",$wpdb->usertable, $key, ".$value.");
        $stmt->execute();
        return  $stmt->get_result();
    }
}
