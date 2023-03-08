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
        //PlayTheGame.getInstance().chooseOperation();
        ;
        Matteo();






        Roberto();

//delimitatore



    }
    public static void Matteo(){

        Hp hp = new Hp(120,120);
        PersistenceInterface.getInstance().store(hp);
        DamageAction action = new DamageAction(20);
        PersistenceInterface.getInstance().store(action);
        ProtectionAction action1 = new ProtectionAction(30);
        PersistenceInterface.getInstance().store(action1);
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(action);
        actions.add(action1);
        Monster monster = new Monster(hp,"Empty Armor","normal",2.0,0,actions,80,null);
        PersistenceInterface.getInstance().store(monster);



        Hp hp1 = new Hp(150,150);
        PersistenceInterface.getInstance().store(hp1);
        DamageAction action2 = new DamageAction(15);
        PersistenceInterface.getInstance().store(action2);
        ProtectionAction action3 = new ProtectionAction(25);
        PersistenceInterface.getInstance().store(action3);
        ArrayList<Action> actions1 = new ArrayList<>();
        actions1.add(action2);
        actions1.add(action3);
        Monster monster1 = new Monster(hp1,"Giant Bear","normal",2.0,0,actions,95,null);
        PersistenceInterface.getInstance().store(monster1);







        Hp hp2 = new Hp(100,100);
        PersistenceInterface.getInstance().store(hp2);
        ProtectionAction action4 = new ProtectionAction(10);
        PersistenceInterface.getInstance().store(action4);
        DamageAction action5 = new DamageAction(10);
        action5.setNextAction(action4);
        PersistenceInterface.getInstance().store(action5);

        ProtectionAction action6 = new ProtectionAction(5);
        PersistenceInterface.getInstance().store(action6);
        DamageAction action7 = new DamageAction(20);
        action7.setNextAction(action6);
        PersistenceInterface.getInstance().store(action7);

        ProtectionAction action8 = new ProtectionAction(60);
        PersistenceInterface.getInstance().store(action8);

        ArrayList<Action> actions2 = new ArrayList<>();
        actions2.add(action5);
        actions2.add(action7);
        actions2.add(action8);

        Monster monster2 = new Monster(hp2,"Green Slime","normal",2.0,0,actions2,100,null);
        PersistenceInterface.getInstance().store(monster2);






        Hp hp3 = new Hp(300,300);
        PersistenceInterface.getInstance().store(hp3);
        ProtectionAction action10 = new ProtectionAction(15);
        PersistenceInterface.getInstance().store(action10);
        DamageAction action11 = new DamageAction(30);
        action11.setNextAction(action10);
        PersistenceInterface.getInstance().store(action11);

        DamageAction action12 = new DamageAction(45);
        PersistenceInterface.getInstance().store(action12);


        ProtectionAction action13 = new ProtectionAction(15);
        PersistenceInterface.getInstance().store(action13);

        ArrayList<Action> actions3 = new ArrayList<>();
        actions3.add(action11);
        actions3.add(action12);
        actions3.add(action13);

        Monster monster3 = new Monster(hp3,"3-Headed Hydra","boss",2.0,0,actions3,350,null);
        PersistenceInterface.getInstance().store(monster3);



        Hp hp4 = new Hp(250,250);
        PersistenceInterface.getInstance().store(hp4);
        DamageAction action14  = new DamageAction(30);
        PersistenceInterface.getInstance().store(action14);
        DamageAction action15 = new DamageAction(50);
        PersistenceInterface.getInstance().store(action15);
        ArrayList<Action> actions4 = new ArrayList<>();
        actions4.add(action14);
        actions4.add(action15);
        Monster monster4 = new Monster(hp4,"Ogre","normal",3.0,0,actions4,300,null);
        PersistenceInterface.getInstance().store(monster4);



        Hp hp5 = new Hp(180,180);
        PersistenceInterface.getInstance().store(hp5);
        DamageAction action16  = new DamageAction(25);
        PersistenceInterface.getInstance().store(action16);
        ProtectionAction action17 = new ProtectionAction(15);
        action17.setNextAction(action16);
        PersistenceInterface.getInstance().store(action17);

        DamageAction action18  = new DamageAction(35);
        PersistenceInterface.getInstance().store(action18);
        ProtectionAction action19 = new ProtectionAction(25);
        action19.setNextAction(action18);
        PersistenceInterface.getInstance().store(action19);

        DamageAction action20  = new DamageAction(50);
        PersistenceInterface.getInstance().store(action20);

        ArrayList<Action> actions5 = new ArrayList<>();
        actions5.add(action17);
        actions5.add(action19);
        actions5.add(action20);
        Monster monster5 = new Monster(hp5,"Giant Skeleton","normal",3.0,0,actions5,250,null);
        PersistenceInterface.getInstance().store(monster5);




        Hp hp6 = new Hp(200,200);
        PersistenceInterface.getInstance().store(hp6);
        DamageAction action21  = new DamageAction(25);
        PersistenceInterface.getInstance().store(action21);
        ProtectionAction action22 = new ProtectionAction(20);
        PersistenceInterface.getInstance().store(action22);
        DamageAction action23 = new DamageAction(50);
        action23.setNextAction(action22);
        PersistenceInterface.getInstance().store(action23);
        DamageAction action24 = new DamageAction(40);
        PersistenceInterface.getInstance().store(action24);



        ArrayList<Action> actions6 = new ArrayList<>();
        actions6.add(action21);
        actions6.add(action23);
        actions6.add(action24);
        Monster monster6 = new Monster(hp6,"Undead Warrior","normal",3.0,0,actions6,250,null);
        PersistenceInterface.getInstance().store(monster6);





        Hp hp7 = new Hp(500,500);
        PersistenceInterface.getInstance().store(hp7);
        DamageAction action25  = new DamageAction(35);
        PersistenceInterface.getInstance().store(action25);
        DamageAction action27 = new DamageAction(20);
        PersistenceInterface.getInstance().store(action27);
       ProtectionAction action26 = new ProtectionAction(100);
        PersistenceInterface.getInstance().store(action26);

        DamageAction action28 = new DamageAction(60);
        PersistenceInterface.getInstance().store(action28);



        ArrayList<Action> actions7 = new ArrayList<>();
        actions7.add(action25);
        actions7.add(action26);
        actions7.add(action27);
        actions7.add(action28);
        Monster monster7 = new Monster(hp7,"Ancient Dragon","boss",3.0,0,actions7,500,null);
        PersistenceInterface.getInstance().store(monster7);






















































    }

    public static void Roberto(){
        CaricamentoDB.carica();
    }
}