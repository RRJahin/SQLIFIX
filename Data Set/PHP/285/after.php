<?php

function facebook_exist($db, $fb_userid, $user_profile2)
{   global $wpdb;
    $fb_id = $user_profile2['id'];
    $stmt = $db->prepare("Select uname from ? where  ?=?");
    $stmt->bind_param("sss",$wpdb->myTable, $fb_userid, $fb_id);
    $stmt->execute();

    $query = $stmt->get_result();
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
