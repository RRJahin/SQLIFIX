public class Dummy{
private void getAllRecords() {
    movieList = new ArrayList<>();
    cursor = sql.rawQuery("SELECT * FROM trans_msg WHERE changdate = '" + todate + "' AND accuntnumber ='" + accntno + "' AND nameofbank='" + accntname + "' ORDER BY changdate desc,msgtime desc", null);
    if (cursor != null) {
        if (cursor.moveToFirst()) {
            do {
                String bb = cursor.getString(cursor.getColumnIndex("nameofbank"));
                String cc = cursor.getString(cursor.getColumnIndex("body"));
                String dd = cursor.getString(cursor.getColumnIndex("transdate"));
                String ee = cursor.getString(cursor.getColumnIndex("category"));
                String ff = cursor.getString(cursor.getColumnIndex("type"));
                String gg = cursor.getString(cursor.getColumnIndex("changdate"));
                String hh = cursor.getString(cursor.getColumnIndex("amount"));
                Log.i("aa", "" + bb);
                Log.i("aa", "" + cc);
                Log.i("addda", "" + dd);
                Log.i("aa", "" + ee);
                Log.i("adsda", "" + ff);
                Log.i("atg87tga", "" + gg);
                Log.i("fffff", "" + hh);
                Log.i("adda", "" + dbmoney);
                int count = cursor.getCount();
                Log.i("count", "" + count);
                id = gettypecat(ff);
                Log.i("movidde", "" + id);
                movie = new Movie(bb, hh, dd, id, ff);
                Log.i("movie", "" + movie);
                movieList.add(movie);
                Log.i("movieList", "" + movieList);
                mAdapter = new MoviesAdapter(movieList);
                Log.i("movieList", "" + mAdapter);
                recyclerView.setAdapter(mAdapter);
                Log.i("recyclerView", "" + recyclerView);
                mAdapter.notifyDataSetChanged();
            } while (cursor.moveToNext());
        } else {
            linearnorecord.setVisibility(View.VISIBLE);
            linearrecord.setVisibility(View.GONE);
        }
    }
}}

