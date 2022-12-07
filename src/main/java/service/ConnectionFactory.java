package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Agenda");

	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

}
