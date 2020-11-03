<?php
function get_editable_authors( $user_id ) {

  global $conn;
  global $wpdb;

	$editable = $wpdb->get_editable_user_ids( $user_id );

	if ( !$editable ) {
		return false;
	} else {
		$editable = join(',', $editable);
		return $conn->query( "SELECT uname FROM $wpdb->users WHERE ID IN ($editable) ORDER BY display_name" );
	}
}
