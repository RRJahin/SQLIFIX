<?php

function getbyattribute($db, $key, $value, $key2 = null, $value2 = null)
{
    global $wpdb;
    if (($key2) && ($value2)) {

        return  $db->query("SELECT * FROM $wpdb->myTable where '$key' = '" . $value . "' AND '$key2' = '" . $value2 . "' and id ={$_POST['id']}");
    } else {

        return  $db->query("SELECT * FROM $wpdb->myTable where '$key' = '" . $value . "' and id = {$_POST['id']}");
    }
}
