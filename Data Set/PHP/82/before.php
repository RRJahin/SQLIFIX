<?php

function facebook_exist($db, $fb_userid, $user_profile2)
{
    $fb_id = $user_profile2['id'];
    $query = $db->query("Select * from table1 where $fb_userid ='$fb_id'");
    if ($query->num_rows > 0) {
        return 1;
    } else {
        return 0;
    }
}
