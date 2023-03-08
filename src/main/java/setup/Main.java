package setup;

import model.AdventurerDescription;
import model.PlayTheGame;
import services.ConfigurationReader;
import services.PersistenceInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        //PersistenceInterface persistence=PersistenceInterface.getInstance();
        //persistence.loadOne(2, Adventurer.class);
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
        /*
        /create action
        ProtectionAction protectionAction=new ProtectionAction();
        protectionAction.setProtection(5);
       DamageAction damageAction=new DamageAction();
       damageAction.setDamage(10);
       damageAction.setNextAction(protectionAction);
       PersistenceInterface.getIstance().store(protectionAction);
       PersistenceInterface.getIstance().store(damageAction);
         */
        /*
        create monster
        Hp hp = new Hp();
            hp.setMaxHp(100);
            hp.resetCurrentHp();
            PersistenceInterface.getIstance().store(hp);
            Monster m = new Monster();
            m.setType("normal");
            m.setName("Browser");
            m.setHp(hp);
            m.setChallengeRating(3);
            PersistenceInterface.getIstance().store(m);
        */
        /*
        try {
            Monster monster=(Monster)PersistenceInterface.getIstance().loadOne(1,Monster.class);
            Action action=(Action) PersistenceInterface.getIstance().loadOne(2,Action.class);
            monster.addActionToAvailable(action);m
            PersistenceInterface.getIstance().update(monster);
        }
        catch (Exception e){
            throw new UnsupportedOperationException(e);
        }
        */
        Logger logger = Logger.getLogger("org.hibernate");
        logger.setLevel(Level.SEVERE);
        PlayTheGame.getInstance().chooseOperation();

        //cvhsdvb
        //kdscnsdcf



//ciao







    }
}