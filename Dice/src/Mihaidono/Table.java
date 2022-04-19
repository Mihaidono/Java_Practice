package Mihaidono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

enum DicePower {
    PowerDice, OddHigh, BadDice, DoubleUp, Common
}

public class Table {
    private final int money = 200000;
    public int playerTurn=0;

    private ArrayList<Integer> diceList = new ArrayList<>();
    public Map<Integer, Player> playerList = new HashMap<>();

    public boolean TableRule_Names(Player player) {
        if (playerList.size() > 1) {
            for (Player p : playerList.values()) {
                if (p.getPlayerName().equals(player.getPlayerName())) {
                    return false;
                }
            }
        }
        return true;
    }

    public Player initiatePlayer(String line) {
        Player player = new Player(line, money);
        return player;
    }

    public int addPlayer(Player newPlayer) {
        if (TableRule_Names(newPlayer)) {
            playerList.put(playerList.size() + 1, newPlayer);
            return 1;
        }
        return -1;
    }

    public int removePlayer(Player rmPlayer) {
        if (!playerList.isEmpty() && playerList.containsValue(rmPlayer)) {
            for(Map.Entry<Integer,Player> entry:playerList.entrySet()){
                if(entry.getValue().equals(rmPlayer)){
                    playerList.remove(entry.getKey(),rmPlayer);
                }
            }
            return 1;
        }
        return -1;
    }

    public void startPhase() {
        //de implementat
    }

    public int checkWinCondition() {
        int maxi = diceList.get(0);
        int maxpos = diceList.get(0);
        for (int i = 0; i < diceList.size(); i++) {  //max thrown value
            if (diceList.get(i) > maxi) {
                maxi = diceList.get(i);
                maxpos = i;
                if (diceList.get(i) == 2) {
                    return i;//returns the position of the player that rolled 2(it being the most powerful value)
                }
            }
        }
        return maxpos;
    }

    public void resetGame() {
        playerList.clear();
        playerTurn=0;
    }

    public int rollDice() {
        Random rand = new Random();
        int firstDice = rand.nextInt(1, 6);
        int secondDice = rand.nextInt(1, 6);
        playerTurn++;
        return firstDice + secondDice;
    }

    public DicePower combinations(int value) {
        return switch (value) {
            case 2 -> DicePower.PowerDice;
            case 11 -> DicePower.OddHigh;
            case 3 -> DicePower.BadDice;
            case 12 -> DicePower.DoubleUp;
            default -> DicePower.Common;
        };
    }

    public String playerListToText() {
        String pString = "Player List:\n ";
        for (Player p : playerList.values()) {
            if (!playerList.get(playerList.size()).getPlayerName().equals(p.getPlayerName())) {
                pString += p.getPlayerName() + ", ";
            } else {
                pString += p.getPlayerName() + ".";
            }
        }
        return pString;
    }
}
