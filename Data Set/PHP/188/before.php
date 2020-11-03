<?php

function facebook_exist($db,$id, $fb_userid, $user_profile)
{   global $wpdb;
    $fb_id = $user_profile['fb_id'];
    $query = $db->query("Select * from $wpdb->myTable where $fb_userid !='$fb_id' and id = $id");
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
