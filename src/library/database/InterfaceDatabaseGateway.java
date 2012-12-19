package library.database;

import library.database.versionController.DatabaseVersionController;
import android.content.ContentValues;

public interface InterfaceDatabaseGateway {
	/**
	 * 
	 * @param data
	 */
	public void insert(ContentValues data);
	/**
	 * 
	 * @param where
	 * @param values
	 */
	public void delete(String where, String[] values);
	/**
	 * 
	 * @param values
	 * @param whereClause
	 * @param whereArgs
	 */
	public void update(ContentValues values, String whereClause, String[] whereArgs);
	/**
	 * 
	 * @return
	 */
	public DatabaseVersionController getVersionController();
}
