<?php

function facebook_exist($db, $fb_userid, $user_profile)
{   global $wpdb;
    $fb_id = $user_profile['fb_id'];
    $query = $db->query("Select uname from $wpdb->usertable where $fb_userid ='$fb_id' AND isActive = TRUE");
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
