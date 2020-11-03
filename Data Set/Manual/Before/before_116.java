public class Dummy{
@Override
public List<Object[]> mailForShare(int member_id) {
    @SuppressWarnings("unchecked") Query<Object[]> query = getSession().createQuery("select a1.item_id, a1.item_name, a3.member_no, a3.nickname, MAX(a2.time), a5.status, a1.done, a1.getter_id.member_no, a1.getter_rate, a1.giver_rate, MIN(a2.readed) from MessageContextBean a2 JOIN a2.itemBean a1 LEFT JOIN a2.memberBean_speaker a3 LEFT JOIN RequestListBean a5 with a1.item_id = a5.item_id AND a3.member_no = a5.requester_id where a1.member_id.member_no = "+member_id+" AND a3.member_no <> "+member_id+" GROUP BY a1.item_id, a1.item_name, a3.member_no, a3.nickname, a5.status, a1.done, a1.getter_id.member_no, a1.getter_rate, a1.giver_rate ORDER BY MAX(a2.time) DESC");
    return query.getResultList();
}}

