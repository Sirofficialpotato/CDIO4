package Player;

import Cards.*;
import Fields.Brewery;
import Fields.Field;
import Fields.FieldShipYard;
import Fields.Properties;

public class Player{
    //Attributes
    private String name;
    private Boolean inJail;
    private boolean JailCard;
    private int Position, oldposition;
    private Wallet wallet = new Wallet();
    private DynamicArr<Cards> jailCards = new DynamicArr<Cards>();
    private DynamicArr<Integer> playerOwnedFields = new DynamicArr<Integer>();
    private int turnsInJail = 0;
    private int lastRoll;

    public Player(String Name)
    {
        name = Name;
        inJail = false;
        JailCard = false;
        Position = 0;
        oldposition = 0;
    }

    public DynamicArr<Integer> getPlayerOwnedFields(){
        return playerOwnedFields;
    }

    public void addToPlayerOwnedFields(){
        playerOwnedFields.add(Position);
    }

    public int getPosition()
    {
        return Position;
    }

    public void setPosition(int Position)
    {
        this.oldposition = this.Position;
        this.Position += Position;
        this.lastRoll = Position;
        if(this.Position >= 40) this.Position -= 40;
        // ved ikke lige om det virker helt
        else if(this.Position < 0) this.Position +=40;
        if(this.Position < this.oldposition && !this.inJail){
            this.setMoney(+4000);
        }
    }

    public void setSpecificPosition(int position){
        this.oldposition = this.Position;
        this.Position = position;
        if(this.Position < this.oldposition && !this.inJail){
            this.setMoney(+4000);
        }
    }
    public int getSpecificPosition(){
        return Position;
    }
    public int getOldposition()
    {
        return oldposition;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String Name){
        this.name = Name;
    }

    //adds or remove jailcard(s) to a player
    public void setJailCard(boolean jailCard) {
        this.JailCard = jailCard;
    }
    public boolean getJailCard()
    {
        return this.JailCard;
    }
    public void addJailCard(JailInteractions jailCard){
        this.jailCards.add(jailCard);
    }

    public int getLastRoll(){
        return this.lastRoll;
    }

    public Cards getPlayerSpecific(){
        for (int i = 0; i < jailCards.size; i++) {
            String tester = jailCards.atIndex(i).getCardText().substring(0,2);
            if(jailCards.atIndex(i) instanceof PayTheBank){
                return this.jailCards.atIndex(i);
            }
        }
        return null;
    }

    public void removePlayerSpecific(){
        for (int i = 0; i < jailCards.size; i++) {
            String tester = jailCards.atIndex(i).getCardText().substring(0,2);
            if(jailCards.atIndex(i) instanceof PayTheBank){
                this.jailCards.removeAt(i);
            }
        }
    }

    public Cards getJailCardOject(){
        for (int i = 0; i < jailCards.size; i++) {
            if(jailCards.atIndex(i) instanceof JailInteractions){
                return jailCards.atIndex(i);
            }
        }
        return null;
    }
    public void removeJailCardObect() {
        for (int i = 0; i < jailCards.size; i++) {
            if (jailCards.atIndex(i) instanceof JailInteractions) {
                jailCards.removeAt(i);
            }
        }
    }
   public int getPlayerAssets(Field[] fields){
        int playerAsset = 0;
        if(playerOwnedFields.current > 0) {
            for (int i = 0; i < playerOwnedFields.size; i++) {
                Field tempField = fields[playerOwnedFields.getArr()[i]];
                if (tempField instanceof Properties) {
                    playerAsset += ((Properties) tempField).getTotalPropertyValue();
                } else if (tempField instanceof Brewery) {
                    playerAsset += ((Brewery) tempField).getPrice();
                } else if (tempField instanceof FieldShipYard) {
                    playerAsset += ((FieldShipYard) tempField).getPrice();
                }
            }
        }
       return playerAsset;
   }

    public boolean hasPlayerSpecific(){
        boolean tester = false;
        for (int i = 0; i < jailCards.size; i++) {
            if(jailCards.atIndex(i) instanceof PayTheBank){
                tester = true;
            }
        }
        return tester;
    }

    public void setInJail(boolean input){
        this.inJail = input;
    }
    public boolean getInJail()
    {
        return inJail;
    }
    public int getTurnsInJail(){ return turnsInJail; }
    public void addToTurnsInJail(int Value){
        this.turnsInJail += Value;
    }



    public int getMoney(){
        return wallet.getMoney();
    }

    public void setMoney(int money){
        wallet.setMoney(money);
    }

    public DynamicArr<Cards> getjailCards() {
        return jailCards;
    }
}
