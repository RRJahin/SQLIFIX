<?php
function get_editable_authors( $user_id ) {

  global $conn;
  global $wpdb;

	$editable = $wpdb->get_editable_user_ids( $user_id );

	if ( !$editable ) {
		return false;
	} else {
        $editable = join(',', $editable);
        $stmt = $conn->prepare( "SELECT username,email FROM userTable WHERE ID IN (?) ORDER BY display_name" );
        $stmt->bind_param('s',$editable);
        $stmt->execute();
        return  $stmt->get_result();
	}

}
