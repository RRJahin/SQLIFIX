<?php

function facebook_exist($db, $fb_userid, $user_profile2)
{   global $wpdb;
    $fb_id = $user_profile2['id'];
    $query = $db->query("Select uname from $wpdb->myTable where $fb_userid ='$fb_id'");
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
