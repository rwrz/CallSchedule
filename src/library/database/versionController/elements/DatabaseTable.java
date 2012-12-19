package library.database.versionController.elements;

import java.util.List;

public class DatabaseTable 
{
	private String tableName = "";
	private List<DatabaseTableColumn> columns;

	public DatabaseTable(String tableName) 
	{
		this.tableName = tableName;
	}
	
	public DatabaseTable(String tableName, List<DatabaseTableColumn> columns) 
	{
		this.tableName = tableName;
		this.columns = columns;
	}

	public DatabaseTable(String tableName, DatabaseTableColumn[] paramColumns) 
	{
		this.tableName = tableName;
		
		for (DatabaseTableColumn column : paramColumns) { 
			this.columns.add(column);
		}
	}
	
	public List<DatabaseTableColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<DatabaseTableColumn> columns) {
		this.columns = columns;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String createTableSql()
	{
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + "(";
		
		for (int i = 0; i < columns.size(); i++) {
			if (i != 0) {
				sql += ", ";
			}
			sql += columns.get(i).getSql();
		}
		
		sql += ")";
		
		return sql;
	}
	
	public String dropTableSql()
	{
		return "DROP TABLE IF EXISTS " + tableName;
	}
	
	//TODO : update table
	public String updateTableSql(int currentVersion)
	{
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + "(";
		
		for (int i = 0; i < columns.size(); i++) {
			if (columns.get(i).getSinceVersion() <= currentVersion) {
				sql += columns.get(i).getSql();
			}
		}
		
		sql += ")";
		
		return sql;
	}
}
