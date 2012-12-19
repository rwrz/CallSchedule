package library.database.versionController;

import java.util.List;

public class DatabaseVersionController 
{
	List<DatabaseVersion> databaseVersions;
	
	public String getSqlQueryToCreate(int version)
	{
		for (DatabaseVersion databaseVersion : databaseVersions) {
			if (databaseVersion.getVersionNumber() == version) {
				return databaseVersion.getSqlQueryToCreate();
			}
		}
		
		return "";
	}
	
	public String getSqlQueryToUpdate(int currentVersion)
	{
		String sql = "";
		for (DatabaseVersion databaseVersion : databaseVersions) {
			if (databaseVersion.getVersionNumber() >= currentVersion) {
				sql += databaseVersion.getSqlQueryToUpdate() + "\n";
			}
		}
		
		return sql;
	}
}
