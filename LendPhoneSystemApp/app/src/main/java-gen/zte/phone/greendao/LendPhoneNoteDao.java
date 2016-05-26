package zte.phone.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import zte.phone.greendao.LendPhoneNote;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LendPhoneNoteTable".
*/
public class LendPhoneNoteDao extends AbstractDao<LendPhoneNote, Long> {

    public static final String TABLENAME = "LendPhoneNoteTable";

    /**
     * Properties of entity LendPhoneNote.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Phone_id = new Property(1, long.class, "phone_id", false, "PHONE_ID");
        public final static Property Lend_phone_name = new Property(2, String.class, "lend_phone_name", false, "LEND_PHONE_NAME");
        public final static Property Lend_phone_time = new Property(3, java.util.Date.class, "lend_phone_time", false, "LEND_PHONE_TIME");
        public final static Property Lend_phone_number = new Property(4, Integer.class, "lend_phone_number", false, "LEND_PHONE_NUMBER");
    };

    private DaoSession daoSession;


    public LendPhoneNoteDao(DaoConfig config) {
        super(config);
    }
    
    public LendPhoneNoteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LendPhoneNoteTable\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"PHONE_ID\" INTEGER NOT NULL ," + // 1: phone_id
                "\"LEND_PHONE_NAME\" TEXT," + // 2: lend_phone_name
                "\"LEND_PHONE_TIME\" INTEGER," + // 3: lend_phone_time
                "\"LEND_PHONE_NUMBER\" INTEGER);"); // 4: lend_phone_number
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LendPhoneNoteTable\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, LendPhoneNote entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getPhone_id());
 
        String lend_phone_name = entity.getLend_phone_name();
        if (lend_phone_name != null) {
            stmt.bindString(3, lend_phone_name);
        }
 
        java.util.Date lend_phone_time = entity.getLend_phone_time();
        if (lend_phone_time != null) {
            stmt.bindLong(4, lend_phone_time.getTime());
        }
 
        Integer lend_phone_number = entity.getLend_phone_number();
        if (lend_phone_number != null) {
            stmt.bindLong(5, lend_phone_number);
        }
    }

    @Override
    protected void attachEntity(LendPhoneNote entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public LendPhoneNote readEntity(Cursor cursor, int offset) {
        LendPhoneNote entity = new LendPhoneNote( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // phone_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // lend_phone_name
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // lend_phone_time
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4) // lend_phone_number
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, LendPhoneNote entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPhone_id(cursor.getLong(offset + 1));
        entity.setLend_phone_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLend_phone_time(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setLend_phone_number(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(LendPhoneNote entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(LendPhoneNote entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getPhoneNoteDao().getAllColumns());
            builder.append(" FROM LendPhoneNoteTable T");
            builder.append(" LEFT JOIN PhoneNoteTable T0 ON T.\"PHONE_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected LendPhoneNote loadCurrentDeep(Cursor cursor, boolean lock) {
        LendPhoneNote entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        PhoneNote phoneNote = loadCurrentOther(daoSession.getPhoneNoteDao(), cursor, offset);
         if(phoneNote != null) {
            entity.setPhoneNote(phoneNote);
        }

        return entity;    
    }

    public LendPhoneNote loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<LendPhoneNote> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<LendPhoneNote> list = new ArrayList<LendPhoneNote>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<LendPhoneNote> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<LendPhoneNote> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}