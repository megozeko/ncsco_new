package net.itechnicians.ncsco.entities;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table PROJECT.
*/
public class ProjectDao extends AbstractDao<Project, Long> {

    public static final String TABLENAME = "PROJECT";

    /**
     * Properties of entity Project.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ProjectName = new Property(1, String.class, "ProjectName", false, "PROJECT_NAME");
        public final static Property ProjectAddress = new Property(2, String.class, "ProjectAddress", false, "PROJECT_ADDRESS");
        public final static Property ProjectDepartment = new Property(3, String.class, "ProjectDepartment", false, "PROJECT_DEPARTMENT");
        public final static Property OfficerMilId = new Property(4, long.class, "officerMilId", false, "OFFICER_MIL_ID");
    };

    private DaoSession daoSession;


    public ProjectDao(DaoConfig config) {
        super(config);
    }
    
    public ProjectDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PROJECT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'PROJECT_NAME' TEXT NOT NULL ," + // 1: ProjectName
                "'PROJECT_ADDRESS' TEXT NOT NULL ," + // 2: ProjectAddress
                "'PROJECT_DEPARTMENT' TEXT," + // 3: ProjectDepartment
                "'OFFICER_MIL_ID' INTEGER NOT NULL );"); // 4: officerMilId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PROJECT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Project entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getProjectName());
        stmt.bindString(3, entity.getProjectAddress());
 
        String ProjectDepartment = entity.getProjectDepartment();
        if (ProjectDepartment != null) {
            stmt.bindString(4, ProjectDepartment);
        }
    }

    @Override
    protected void attachEntity(Project entity) {
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
    public Project readEntity(Cursor cursor, int offset) {
        Project entity = new Project( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // ProjectName
            cursor.getString(offset + 2), // ProjectAddress
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // ProjectDepartment
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Project entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setProjectName(cursor.getString(offset + 1));
        entity.setProjectAddress(cursor.getString(offset + 2));
        entity.setProjectDepartment(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Project entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Project entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getOfficerDao().getAllColumns());
            builder.append(" FROM PROJECT T");
            builder.append(" LEFT JOIN OFFICER T0 ON T.'OFFICER_MIL_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Project loadCurrentDeep(Cursor cursor, boolean lock) {
        Project entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Officer resposibleOfficer = loadCurrentOther(daoSession.getOfficerDao(), cursor, offset);
         if(resposibleOfficer != null) {
            entity.setResposibleOfficer(resposibleOfficer);
        }

        return entity;    
    }

    public Project loadDeep(Long key) {
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
    public List<Project> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Project> list = new ArrayList<Project>(count);
        
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
    
    protected List<Project> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Project> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
