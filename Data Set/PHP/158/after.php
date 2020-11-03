<?php

function facebook_exist($db,$id, $fb_userid, $user_profile)
{
    $fb_id = $user_profile['fb_id'];
    $stmt = $db->prepare("Select * from table1 where  ?!=? and id = ?");
    $stmt->bind_param("sss", $fb_userid, $fb_id, $id);
    $stmt->execute();

    $query = $stmt->get_result();
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
