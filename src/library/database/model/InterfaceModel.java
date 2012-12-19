package library.database.model;

public interface InterfaceModel 
{
	/**
	 * 
	 * @param o
	 */
	public abstract void insert(Object o);
	/**
	 * 
	 * @param id
	 */
	public abstract void delete(String id);
	/**
	 * 
	 * @param o
	 */
	public abstract void update(Object o);
	
	
}
