package Mihaidono;

import java.util.Objects;

public class Player {
    private String name;
    private int money;

    Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getPlayerName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Player:" + name +", Funds: "+ money ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return money == player.money && name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}
