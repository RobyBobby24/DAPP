package setup;

import model.Action;
import model.Card;
import services.PersistenceInterface;

import java.util.ArrayList;
import model.*;
import java.util.List;
import java.util.TreeMap;

public class CaricamentoDB {

    public static void carica(){
        /*
        int[] salta = {29,31,33,41,43,45};
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(1,"","Strike",100, (Effect) PersistenceInterface.getInstance().loadOne(26, Effect.class)));
        cards.add(new Card(1,"","Double Strike",250, (Effect) PersistenceInterface.getInstance().loadOne(27, Effect.class)));
        cards.add(new Card(2,"","Heavy Strike",250, (Effect) PersistenceInterface.getInstance().loadOne(28, Effect.class)));
        cards.add(new Card(1,"","Slashing Strike",250, (Effect) PersistenceInterface.getInstance().loadOne(30, Effect.class)));
        cards.add(new Card(1,"","Big Impact",400, (Effect) PersistenceInterface.getInstance().loadOne(32, Effect.class)));
        cards.add(new Card(2,"","Meteor",600, (Effect) PersistenceInterface.getInstance().loadOne(34, Effect.class)));
        cards.add(new Card(1,"","Defend",100, (Effect) PersistenceInterface.getInstance().loadOne(35, Effect.class)));
        cards.add(new Card(1,"","Iron Plate",250, (Effect) PersistenceInterface.getInstance().loadOne(36, Effect.class)));
        cards.add(new Card(2,"","Total Defense",250, (Effect) PersistenceInterface.getInstance().loadOne(37, Effect.class)));
        cards.add(new Card(1,"","Reinforcement",200, (Effect) PersistenceInterface.getInstance().loadOne(38, Effect.class)));
        cards.add(new Card(0,"","Small Help",350, (Effect) PersistenceInterface.getInstance().loadOne(39, Effect.class)));
        cards.add(new Card(2,"","Allies Are Coming",350, (Effect) PersistenceInterface.getInstance().loadOne(40, Effect.class)));
        cards.add(new Card(1,"","Sword & Shield",300, (Effect) PersistenceInterface.getInstance().loadOne(42, Effect.class)));
        cards.add(new Card(1,"","Help & Sword",400, (Effect) PersistenceInterface.getInstance().loadOne(44, Effect.class)));
        cards.add(new Card(1,"","Help & Shield",400, (Effect) PersistenceInterface.getInstance().loadOne(46, Effect.class)));
        for (Card card : cards) PersistenceInterface.getInstance().store(card);

        for (int j = 0; j <  2; j++) {
            Deck deck1 = new Deck();
            for (int i = 0; i < 4; i++) deck1.addCard(cards.get(0));
            for (int i = 0; i < 5; i++) deck1.addCard(cards.get(6));
            deck1.addCard(cards.get(9));
            PersistenceInterface.getInstance().store(deck1);
        }

         */
        /*
        int[] coins = {10,100,200};
        List<Card> cards = (List<Card>) PersistenceInterface.getInstance().search(new TreeMap<>(),Card.class);
        for (int coin : coins) {
            for (Card card : cards) {
                Treasure tresure = new Treasure();
                tresure.setRewardCoins(coin);
                tresure.setCard(card);
                PersistenceInterface.getInstance().store(tresure);
            }
        }
         */








    }
}
