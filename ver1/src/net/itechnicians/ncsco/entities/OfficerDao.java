package net.itechnicians.ncsco.entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table OFFICER.
*/
public class OfficerDao extends AbstractDao<Officer, Long> {

    public static final String TABLENAME = "OFFICER";

    /**
     * Properties of entity Officer.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property OfficerName = new Property(1, String.class, "officerName", false, "OFFICER_NAME");
        public final static Property OfficerAddress = new Property(2, String.class, "officerAddress", false, "OFFICER_ADDRESS");
        public final static Property OfficerBirthDate = new Property(3, double.class, "officerBirthDate", false, "OFFICER_BIRTH_DATE");
        public final static Property OfficerRank = new Property(4, String.class, "officerRank", false, "OFFICER_RANK");
        public final static Property OfficerDepartment = new Property(5, String.class, "officerDepartment", false, "OFFICER_DEPARTMENT");
        public final static Property OfficerPosition = new Property(6, String.class, "officerPosition", false, "OFFICER_POSITION");
        public final static Property OfficerMilId = new Property(7, long.class, "officerMilId", false, "OFFICER_MIL_ID");
    };


    public OfficerDao(DaoConfig config) {
        super(config);
    }
    
    public OfficerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'OFFICER' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'OFFICER_NAME' TEXT NOT NULL ," + // 1: officerName
                "'OFFICER_ADDRESS' TEXT NOT NULL ," + // 2: officerAddress
                "'OFFICER_BIRTH_DATE' REAL NOT NULL ," + // 3: officerBirthDate
                "'OFFICER_RANK' TEXT NOT NULL ," + // 4: officerRank
                "'OFFICER_DEPARTMENT' TEXT," + // 5: officerDepartment
                "'OFFICER_POSITION' TEXT," + // 6: officerPosition
                "'OFFICER_MIL_ID' INTEGER NOT NULL );"); // 7: officerMilId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'OFFICER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Officer entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getOfficerName());
        stmt.bindString(3, entity.getOfficerAddress());
        stmt.bindDouble(4, entity.getOfficerBirthDate());
        stmt.bindString(5, entity.getOfficerRank());
 
        String officerDepartment = entity.getOfficerDepartment();
        if (officerDepartment != null) {
            stmt.bindString(6, officerDepartment);
        }
 
        String officerPosition = entity.getOfficerPosition();
        if (officerPosition != null) {
            stmt.bindString(7, officerPosition);
        }
        stmt.bindLong(8, entity.getOfficerMilId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Officer readEntity(Cursor cursor, int offset) {
        Officer entity = new Officer( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // officerName
            cursor.getString(offset + 2), // officerAddress
            cursor.getDouble(offset + 3), // officerBirthDate
            cursor.getString(offset + 4), // officerRank
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // officerDepartment
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // officerPosition
            cursor.getLong(offset + 7) // officerMilId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Officer entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOfficerName(cursor.getString(offset + 1));
        entity.setOfficerAddress(cursor.getString(offset + 2));
        entity.setOfficerBirthDate(cursor.getDouble(offset + 3));
        entity.setOfficerRank(cursor.getString(offset + 4));
        entity.setOfficerDepartment(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOfficerPosition(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setOfficerMilId(cursor.getLong(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Officer entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Officer entity) {
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
    
}
