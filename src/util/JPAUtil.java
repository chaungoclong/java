package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NAME = "EXAM";
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return entityManagerFactory;
	}
	
	public static void close() {
		if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
			entityManagerFactory.close();
		}
	}
}
