package library.database.versionController.elements;

public class DatabaseTableColumn 
{
	private String columnName;
	private String type;
	private boolean autoincrement;
	private boolean primaryKey;
	private int sinceVersion;
	
	public DatabaseTableColumn(int sinceVersion, String columnName, String type, boolean autoincrement, boolean primaryKey) 
	{
		this.sinceVersion = sinceVersion;
		this.columnName = columnName;
		this.type = type;
		this.autoincrement = autoincrement;
		this.primaryKey = primaryKey;
	}

	public DatabaseTableColumn(int sinceVersion, String columnName, String type) 
	{
		this.sinceVersion = sinceVersion;
		this.columnName = columnName;
		this.type = type;
		this.autoincrement = false;
		this.primaryKey = false;
	}

	public DatabaseTableColumn(int sinceVersion, String columnName, String type, boolean autoincrement)
	{
		this.sinceVersion = sinceVersion;
		this.columnName = columnName;
		this.type = type;
		this.autoincrement = autoincrement;
		this.primaryKey = false;
	}

	public String getColumnName() 
	{
		return columnName;
	}
	
	public void setColumnName(String columnName) 
	{
		this.columnName = columnName;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public boolean isAutoincrement() 
	{
		return autoincrement;
	}
	
	public void setAutoincrement(boolean autoincrement) 
	{
		this.autoincrement = autoincrement;
	}
	public boolean isPrimaryKey() 
	{
		return primaryKey;
	}
	
	public void setPrimaryKey(boolean primaryKey) 
	{
		this.primaryKey = primaryKey;
	}
	
	public int getSinceVersion() {
		return sinceVersion;
	}

	public void setSinceVersion(int sinceVersion) {
		this.sinceVersion = sinceVersion;
	}

	public String getSql()
	{
		String sql = columnName + " " + type;
		
		if(isPrimaryKey()) {
			sql += " PRIMARY KEY";
		}
		
		if (isAutoincrement()) {
			sql += " AUTOINCREMENT";
		}
		
		return sql;
	}
	
}
