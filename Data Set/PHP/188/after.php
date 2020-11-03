<?php

function facebook_exist($db,$id, $fb_userid, $user_profile)
{   global $wpdb;
    $fb_id = $user_profile['fb_id'];
    $stmt = $db->prepare("Select * from ? where  ?!=? and id = ?");
    $stmt->bind_param("ssss",$wpdb->myTable, $fb_userid, $fb_id,$id);
    $stmt->execute();

    $query = $stmt->get_result();
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
