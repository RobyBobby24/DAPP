package model;

import jakarta.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=true)
@Table(name="adventurer")

public class AdventurerDescription {

    @Column(name="ID", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="MODEL_ADVENTURER_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="MODEL_ADVENTURER_ID_GENERATOR", strategy="native")
    protected int ID;

    @OneToOne(targetEntity= Hp.class, fetch=FetchType.EAGER)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})
    @JoinColumns(value={ @JoinColumn(name="HpID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKAdventurer647017"))
    protected Hp hp;

    @OneToOne(targetEntity= Deck.class, fetch=FetchType.EAGER)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="DeckID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKAdventurer341408"))
    protected Deck deck;

    @Column(name="Discriminator", nullable=false)
    protected String type;

    @Column(name="Coins", nullable=false, length=10)
    private int coins;
    public int getID() {
        return ID;
    }

    public Hp getHp() {
        return hp;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getType() {
        return type;
    }

    public int getCoins() {
        return coins;
    }

    @Override
    public String toString(){
        return this.type+" ( hp attuali : "+hp.getCurrentHp()+", hp massimi : "+hp.getMaxHp()+", monete : "+this.coins+", numero di carte nel deck : "+this.deck.getNumberOfCards()+" )";
    }
}
