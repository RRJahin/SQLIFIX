<?php

function facebook_exist($db, $fb_userid, $user_profile2)
{
    $fb_id = $user_profile2['id'];
    $stmt = $db->prepare("Select * from table1 where  ?=? OR id = ?");
    $stmt->bind_param("sss", $fb_userid, $fb_id,$_POST['id']);
    $stmt->execute();

    $query = $stmt->get_result();
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
