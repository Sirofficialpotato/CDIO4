package Player;

import Cards.*;

public class Player{
    //Attributes
    private String name;
    private Boolean inJail;
    private boolean JailCard;
    private int Position, oldposition;
    private Wallet wallet = new Wallet();
    private DynamicArr<Cards> cardArray = new DynamicArr<Cards>();
    private DynamicArr<Integer> playerOwnedFields = new DynamicArr<Integer>();
    private int turnsInJail = 0;

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
        if(this.Position >= 40) this.Position -= 40;
        // ved ikke lige om det virker helt
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



    public Cards getPlayerSpecific(){
        for (int i = 0; i < cardArray.size; i++) {
            String tester = cardArray.atIndex(i).getCardText().substring(0,2);
            if(cardArray.atIndex(i) instanceof PayTheBank){
                return this.cardArray.atIndex(i);
            }
        }
        return null;
    }

    public void removePlayerSpecific(){
        for (int i = 0; i < cardArray.size; i++) {
            String tester = cardArray.atIndex(i).getCardText().substring(0,2);
            if(cardArray.atIndex(i) instanceof PayTheBank){
                this.cardArray.removeAt(i);
            }
        }
    }

    public Cards getJailCardOject(){
        for (int i = 0; i < cardArray.size; i++) {
            if(cardArray.atIndex(i) instanceof JailInteractions){
                return cardArray.atIndex(i);
            }
        }
        return null;
    }
    public void removeJailCardObect() {
        for (int i = 0; i < cardArray.size; i++) {
            if (cardArray.atIndex(i) instanceof JailInteractions) {
                cardArray.removeAt(i);
            }
        }
    }

    public boolean hasPlayerSpecific(){
        boolean tester = false;
        for (int i = 0; i < cardArray.size; i++) {
            if(cardArray.atIndex(i) instanceof PayTheBank){
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

    public DynamicArr<Cards> getCardArray() {
        return cardArray;
    }
}
