package library.database.versionController;

import java.util.List;

import library.database.versionController.elements.DatabaseTable;

public class DatabaseVersion 
{
	private int versionNumber;
	private List<DatabaseTable> databaseTables;
	
	public DatabaseVersion(int versionNumber, List<DatabaseTable> databaseTables) {
		this.versionNumber = versionNumber;
		this.databaseTables = databaseTables;
	}

	public DatabaseVersion(int versionNumber, DatabaseTable[] paramDatabaseTables) {
		this.versionNumber = versionNumber;
		
		for (DatabaseTable databaseTable : paramDatabaseTables) {
			this.databaseTables.add(databaseTable);
		}
		
	}
	
	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}
	
	public String getSqlQueryToCreate()
	{
		String sql = "";
		
		for (DatabaseTable databaseTable : databaseTables) {
			sql += databaseTable.createTableSql() + "\n";
		}
		
		return sql;
	}

	public String getSqlQueryToUpdate()
	{
		String sql = "";
		
		for (DatabaseTable databaseTable : databaseTables) {
			sql += databaseTable.updateTableSql(versionNumber) + "\n";
		}
		
		return sql;
	}
}
