package library.database;

import library.database.versionController.DatabaseVersionController;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public abstract class AbstractDatabaseGateway extends SQLiteOpenHelper implements InterfaceDatabaseGateway
{
	protected String table = "";
	protected static String databaseName = "";
	protected static CursorFactory cursorFactory = null;
	protected static int currentVersion = 1;
	private DatabaseVersionController versionController;
	
	public AbstractDatabaseGateway(Context context) 
	{
		super(context, databaseName, cursorFactory, currentVersion);
		versionController = getVersionController();
	}

	public void insert(ContentValues values) 
	{
		getWritableDatabase().insert(table, null, values);
	}
	
	public void delete(String where, String[] values)
	{
		getWritableDatabase().delete(table, where, values);
	}

	public void update(ContentValues values, String whereClause, String[] whereArgs) 
	{
		getWritableDatabase().update(table, values, whereClause, whereArgs);
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(versionController.getSqlQueryToCreate(currentVersion));
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL(versionController.getSqlQueryToUpdate(oldVersion));
		
	}
}
