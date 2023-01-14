package setup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Card;
import model.DamageEffect;
import model.Deck;
import services.PersistenceInterface;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();

        try{
            transaction.begin();
            Card card= (Card) PersistenceInterface.getIstance().loadOne(1,Card.class);
            System.out.println(card.var_dump());
            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
