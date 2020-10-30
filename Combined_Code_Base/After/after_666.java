class Dummy{
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    if (oldVersion < 2 && newVersion >= 2) {
        db.execSQL("update " + Account.TABLENAME + " set " + Account.OPTIONS + " = " + Account.OPTIONS + " | 8");
    }
    if (oldVersion < 3 && newVersion >= 3) {
        db.execSQL("ALTER TABLE " + Message.TABLENAME + " ADD COLUMN " + Message.TYPE + " NUMBER");
    }
    if (oldVersion < 5 && newVersion >= 5) {
        db.execSQL("DROP TABLE " + Contact.TABLENAME);
        db.execSQL(CREATE_CONTATCS_STATEMENT);
        db.execSQL("UPDATE " + Account.TABLENAME + " SET " + Account.ROSTERVERSION + " = NULL");
    }
    if (oldVersion < 6 && newVersion >= 6) {
        db.execSQL("ALTER TABLE " + Message.TABLENAME + " ADD COLUMN " + Message.TRUE_COUNTERPART + " TEXT");
    }
    if (oldVersion < 7 && newVersion >= 7) {
        db.execSQL("ALTER TABLE " + Message.TABLENAME + " ADD COLUMN " + Message.REMOTE_MSG_ID + " TEXT");
        db.execSQL("ALTER TABLE " + Contact.TABLENAME + " ADD COLUMN " + Contact.AVATAR + " TEXT");
        db.execSQL("ALTER TABLE " + Account.TABLENAME + " ADD COLUMN " + Account.AVATAR + " TEXT");
    }
    if (oldVersion < 8 && newVersion >= 8) {
        db.execSQL("ALTER TABLE " + Conversation.TABLENAME + " ADD COLUMN " + Conversation.ATTRIBUTES + " TEXT");
    }
    if (oldVersion < 9 && newVersion >= 9) {
        db.execSQL("ALTER TABLE " + Contact.TABLENAME + " ADD COLUMN " + Contact.LAST_TIME + " NUMBER");
        db.execSQL("ALTER TABLE " + Contact.TABLENAME + " ADD COLUMN " + Contact.LAST_PRESENCE + " TEXT");
    }
    if (oldVersion < 10 && newVersion >= 10) {
        db.execSQL("ALTER TABLE " + Message.TABLENAME + " ADD COLUMN " + Message.RELATIVE_FILE_PATH + " TEXT");
    }
    if (oldVersion < 11 && newVersion >= 11) {
        db.execSQL("ALTER TABLE " + Contact.TABLENAME + " ADD COLUMN " + Contact.GROUPS + " TEXT");
        db.execSQL("delete from " + Contact.TABLENAME);
        db.execSQL("update " + Account.TABLENAME + " set " + Account.ROSTERVERSION + " = NULL");
    }
    if (oldVersion < 12 && newVersion >= 12) {
        db.execSQL("ALTER TABLE " + Message.TABLENAME + " ADD COLUMN " + Message.SERVER_MSG_ID + " TEXT");
    }
    if (oldVersion < 13 && newVersion >= 13) {
        db.execSQL("delete from " + Contact.TABLENAME);
        db.execSQL("update " + Account.TABLENAME + " set " + Account.ROSTERVERSION + " = NULL");
    }
    if (oldVersion < 14 && newVersion >= 14) {
        Cursor cursor = db.rawQuery("select * from " + Conversation.TABLENAME, new String[0]);
        while (cursor.moveToNext()) {
            String newJid;
            try {
                newJid = Jid.fromString(cursor.getString(cursor.getColumnIndex(Conversation.CONTACTJID))).toString();
            } catch (InvalidJidException ignored) {
                Log.e(Config.LOGTAG, "Failed to migrate Conversation CONTACTJID " + cursor.getString(cursor.getColumnIndex(Conversation.CONTACTJID)) + ": " + ignored + ". Skipping...");
                continue;
            }
            String[] updateArgs = { newJid, cursor.getString(cursor.getColumnIndex(Conversation.UUID)) };
            db.execSQL("update " + Conversation.TABLENAME + " set " + Conversation.CONTACTJID + " = ? " + " where " + Conversation.UUID + " = ?", updateArgs);
        }
        cursor.close();
        cursor = db.rawQuery("select * from " + Contact.TABLENAME, new String[0]);
        while (cursor.moveToNext()) {
            String newJid;
            try {
                newJid = Jid.fromString(cursor.getString(cursor.getColumnIndex(Contact.JID))).toString();
            } catch (InvalidJidException ignored) {
                Log.e(Config.LOGTAG, "Failed to migrate Contact JID " + cursor.getString(cursor.getColumnIndex(Contact.JID)) + ": " + ignored + ". Skipping...");
                continue;
            }
            String[] updateArgs = { newJid, cursor.getString(cursor.getColumnIndex(Contact.ACCOUNT)), cursor.getString(cursor.getColumnIndex(Contact.JID)) };
            db.execSQL("update " + Contact.TABLENAME + " set " + Contact.JID + " = ? " + " where " + Contact.ACCOUNT + " = ? " + " AND " + Contact.JID + " = ?", updateArgs);
        }
        cursor.close();
        cursor = db.rawQuery("select * from " + Account.TABLENAME, new String[0]);
        while (cursor.moveToNext()) {
            String newServer;
            try {
                newServer = Jid.fromParts(cursor.getString(cursor.getColumnIndex(Account.USERNAME)), cursor.getString(cursor.getColumnIndex(Account.SERVER)), "mobile").getDomainpart();
            } catch (InvalidJidException ignored) {
                Log.e(Config.LOGTAG, "Failed to migrate Account SERVER " + cursor.getString(cursor.getColumnIndex(Account.SERVER)) + ": " + ignored + ". Skipping...");
                continue;
            }
            String[] updateArgs = { newServer, cursor.getString(cursor.getColumnIndex(Account.UUID)) };
            db.execSQL("update " + Account.TABLENAME + " set " + Account.SERVER + " = ? " + " where " + Account.UUID + " = ?", updateArgs);
        }
        cursor.close();
    }
}}

