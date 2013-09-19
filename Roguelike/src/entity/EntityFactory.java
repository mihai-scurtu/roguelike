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
	
//	public Entity create() {
//		return this.create("entity", "", 0, 0);
//	}
//
//	public Entity create(String type, String name) {
//		return this.create(type, name, 0, 0);
//	}
//	
//	public Entity create(int x, int y) {
//		return this.create("entity", "", x, y);
//	}
//	
//	public Entity create(String type, int x, int y) {
//		return this.create(type, "", x, y);
//	}
//	
//	public Entity create(String name, String type, int x, int y) {
//		return new Entity(name, type, x, y);
//	}
	
	public static int nextID() {
		return ++id;
	}
}
