package facades;

import entities.Owner;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class BoatFacade {
    public static BoatFacade instance;
    private static EntityManagerFactory emf;

    public BoatFacade() {
    }

    public static BoatFacade getBoatFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BoatFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //
//    //TODO Remove/Change this before use
//    public long getRenameMeCount(){
//        EntityManager em = emf.createEntityManager();
//        try{
//            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
//            return renameMeCount;
//        }finally{
//            em.close();
//        }
//
//    }
    public List<Owner> getAllOwners() {
        List<Owner> ownerList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Owner> query = em.createQuery("select o from Owner o", entities.Owner.class);
            List<Owner> owners = query.getResultList();

            for (Owner o: owners) {
                ownerList.add(o);
            }
            return ownerList;

        } finally {
            em.close();
        }

    }
}
