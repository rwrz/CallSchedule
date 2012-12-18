package library.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public abstract class AbstractDatabaseGateway implements InterfaceDatabaseGateway
{
	private SQLiteDatabase dbConection;

	protected String table = "";
	
	protected int mode = Context.MODE_PRIVATE;
	
	protected CursorFactory cursorFactory = null;
	
	public AbstractDatabaseGateway(Context context) 
	{
		dbConection = context.openOrCreateDatabase(table, mode, cursorFactory);
	}

	@Override
	public void insert(ContentValues values) 
	{
		dbConection.insert(table, null, values);
	}
	
	@Override
	public void delete(String where, String[] values)
	{
		dbConection.delete(table, where, values);
	}

	@Override
	public void update(ContentValues values, String whereClause, String[] whereArgs) 
	{
		dbConection.update(table, values, whereClause, whereArgs);
		
	}
}
