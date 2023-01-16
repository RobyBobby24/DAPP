package setup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.*;
import services.PersistenceInterface;

import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        PersistenceInterface persistence=PersistenceInterface.getIstance();
        /*
        DamageEffect effect=new DamageEffect();
        effect.setDamage(10);
        effect.setTarget(true);
        persistence.store(effect);
        Card card=new Card();
        card.setEnergyCost(1);
        card.setEffect(effect);
        persistence.store(card);
        Deck deck=new Deck();
        deck.addCard(card);
        persistence.store(deck);
        //Deck deck= (Deck) persistence.loadOne(6,Deck.class);
        System.out.println("daje");
        //deck.getCards().get(0).var_dump();
        */
        /*
        Deck deck=(Deck)persistence.loadOne(6,Deck.class);
        Card card=(Card)persistence.loadOne(2,Card.class);
        deck.addCard(card);
        persistence.update(deck);
        */
        //System.out.println(persistence.loadAdventurer(Warrior.class));
        try {
            AdventurerFactory.getInstance().setAdventurerClass(Warrior.class);
            System.out.println(Adventurer.getInstance().getHp().var_dump());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
