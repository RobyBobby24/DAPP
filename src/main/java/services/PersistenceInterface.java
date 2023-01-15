package services;

import jakarta.persistence.*;
import model.Adventurer;

import java.util.ArrayList;
import java.util.List;

public class PersistenceInterface {

    private static PersistenceInterface istance;
    private PersistenceInterface() {
    }

    public static PersistenceInterface getIstance() {
        if(PersistenceInterface.istance!=null){
            return istance;
        }
        else{
            PersistenceInterface.istance= new PersistenceInterface();
            return istance;
        }
    }

    public void store(Object entity){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public Object loadOne(int id,Class objClass){
        Object result;
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();

        try{
            transaction.begin();
            result=entityManager.find(objClass,id);
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return result;
    }


    public void update(Object entity){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public void delete(Object entity){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public List genericQuery(String from,String select,String where){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        List result;

        try{
            transaction.begin();
            Query query = entityManager.createQuery("SELECT "+select+" FROM "+from+" WHERE "+where);
            result = query.getResultList();
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return result;
    }

    public Adventurer loadAdventurer(Class adventurerClass){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        Adventurer result;

        try{
            transaction.begin();
            Query query = entityManager.createQuery("SELECT Adventurer FROM Adventurer WHERE Adventurer.class="+adventurerClass.getName());
            result =(Adventurer) query.getSingleResult();
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return result;
    }
}
