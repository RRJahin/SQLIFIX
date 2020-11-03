<?php

function facebook_exist($db, $fb_userid, $user_profile2)
{
    $fb_id = $user_profile2['id'];
    global $wpdb;
    $stmt = $db->prepare("Select * from ? where  ?=? and id = ?");
    $stmt->bind_param("ssss",$wpdb->myTable, $fb_userid, $fb_id,$_POST['id']);
    $stmt->execute();

    $query = $stmt->get_result();
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
