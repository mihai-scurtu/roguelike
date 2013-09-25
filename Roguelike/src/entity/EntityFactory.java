package entity;

public class EntityFactory {
	private static int id = 0;
	private static EntityFactory instance;
	
	private EntityFactory() {
	}
	
	public static EntityFactory getInstance() {
		if(instance == null) {
			instance = new EntityFactory();
		}
		
		return instance;
	}
	
	public static int nextID() {
		return ++id;
	}
}
