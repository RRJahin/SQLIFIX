<?php

function getbyattribute($db, $key, $value, $key2 = null, $value2 = null)
{

    if (($key2) && ($value2)) {

        return  $db->query("SELECT * FROM table1 where '$key' = '" . $value . "' AND '$key2' = '" . $value2 . "' and id ={$_POST['id']}");
    } else {

        return  $db->query("SELECT * FROM table1 where '$key' = '" . $value . "' and id = {$_POST['id']}");
    }
}
