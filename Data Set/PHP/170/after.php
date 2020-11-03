<?php
function checkexist($db,$field,$value,$field2=null,$value2=null){

    $returnValue = false;
    global $wpdb;
    if ($field2 && $value2){
        $stmt = $db->prepare("SELECT count(*) as count FROM ? WHERE ? = ? AND  ? = ? and id = ?"); 
        $stmt->bind_param("ssssss", $wpdb->myTable,$field,".$value.",$field2,".$value2.", $_POST['id']);
        $stmt->execute();

        $query = $stmt->get_result();

    }else {
        $stmt = $db->prepare("SELECT count(*) as count FROM ? WHERE ? = ? and id =? "); 
        $stmt->bind_param("ssss",$wpdb->myTable,$field, ".$value.", $_POST['id']);
        $stmt->execute();
        $query = $stmt->get_result();

    }  

     if ($query->num_rows() > 0){

       foreach ($query->result() as $row)

        {

          $count =  $row->count;

        }

    }

    if ($count > 0){

       $returnValue = true;   

    }

   return $returnValue;

   }
?>