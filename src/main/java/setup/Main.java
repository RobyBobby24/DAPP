package setup;

import model.*;
import services.ConfigurationReader;
import services.PersistenceInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

        //xkjehckehc


//delimitatore
        Hp hp = new Hp(60,60);
        PersistenceInterface.getInstance().store(hp);
        DamageAction action = new DamageAction(10);
        PersistenceInterface.getInstance().store(action);
        DamageAction action2 = new DamageAction(15);
        PersistenceInterface.getInstance().store(action2);
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(action);
        actions.add(action2);
        Monster monster = new Monster(hp,"Wolf","normal",1.0,0,actions,25,null);

        Hp hp1 = new Hp(30,30);
        PersistenceInterface.getInstance().store(hp1);
        DamageAction action3 = new DamageAction(8);
        PersistenceInterface.getInstance().store(action3);
        DamageAction action4 = new DamageAction(12);
        action4.setNextAction(new ProtectionAction(5));
        PersistenceInterface.getInstance().store(action4);
        ArrayList<Action> actions1 = new ArrayList<>();
        actions.add(action3);
        actions.add(action4);
        Monster monster1 = new Monster(hp1,"Cobra","normal",1.0,0,actions1,15,null);


        Hp hp4 = new Hp(50,50);
        PersistenceInterface.getInstance().store(hp4);
        DamageAction action5 = new DamageAction(10);
        PersistenceInterface.getInstance().store(action5);
        DamageAction action6 = new DamageAction(8);
        action6.setNextAction(new ProtectionAction(8));
        PersistenceInterface.getInstance().store(action6);
        ProtectionAction action7 = new ProtectionAction(15);
        PersistenceInterface.getInstance().store(action7);
        ArrayList<Action> actions3 = new ArrayList<>();
        actions.add(action5);
        actions.add(action6);
        actions.add(action7);
        Monster monster2 = new Monster(hp4,"Goblin","normal",1.0,0,actions3,35,null);

        Hp hp5 = new Hp(200,200);
        PersistenceInterface.getInstance().store(hp5);
        DamageAction action8 = new DamageAction(20);
        PersistenceInterface.getInstance().store(action8);
        ProtectionAction action9 = new ProtectionAction(30);
        PersistenceInterface.getInstance().store(action9);
        ProtectionAction action10 = new ProtectionAction(15);
        DamageAction action11 = new DamageAction(15);
        action10.setNextAction(action11);
        PersistenceInterface.getInstance().store(action10);
        ArrayList<Action> actions4 = new ArrayList<>();
        actions.add(action8);
        actions.add(action9);
        actions.add(action10);
        Monster monster3 = new Monster(hp5,"Dark Sorcerer","boss",1.0,0,actions4,250,null);



    }
}