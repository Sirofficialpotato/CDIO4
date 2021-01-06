package Player;

public class Wallet {
    private int money;
    public Wallet(){

    }
    public void setMoney(int money) {

        // Placeholder - Should "minus money" be possible?
        this.money += money;
        if(this.money < 0) {
            this.money = 0;
        }
    }
    public int getMoney() {
        return money;
    }

}
