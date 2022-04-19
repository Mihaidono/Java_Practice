package Mihaidono;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiceWindow {

    private JButton rollDice;
    private JLabel diceValuePane;
    private JLabel playerListPane;
    private JTextPane playerChatLog;
    private JPanel mainPane;
    private JLabel playerMoneyPane;
    private JLabel playerNamePane;
    private JTextField playerChatMessageBar;
    private JButton enterPlayerMessage;

    public boolean session_started = false;
    public int rolledDice = 0;

    DiceWindow() {

        Table table = new Table();
        JFrame myFrame = new JFrame("Dice");
        myFrame.setContentPane(mainPane);
        myFrame.setSize(720, 600);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //creating a menu bar and a menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Main Menu");

        //created the items and initiated the names
        JMenuItem addPlayer, removePlayer, startGame, resetGame;
        addPlayer = new JMenuItem("Add player");
        removePlayer = new JMenuItem("Remove player");
        startGame = new JMenuItem("Start the Game");
        resetGame = new JMenuItem("Reset the Game");

        //added the items to the menu
        menu.add(addPlayer);
        menu.add(removePlayer);
        menu.add(startGame);
        menu.add(resetGame);

        //added the menu to the bar
        menuBar.add(menu);
        myFrame.setJMenuBar(menuBar);

        resetGame.setVisible(false);

        //adding actions to the menu items
        addPlayer.addActionListener(e -> {
            if (!session_started) {
                String playerData=JOptionPane.showInputDialog(myFrame, "Introduce the player's name:");
                if(playerData!=null){
                    if (table.addPlayer(table.initiatePlayer(playerData)) == 1) {
                        JOptionPane.showMessageDialog(myFrame, "The player has been added!");
                        playerListPane.setText(table.playerListToText());
                    } else JOptionPane.showMessageDialog(myFrame, "The player couldn't be added!");
                }
            } else JOptionPane.showMessageDialog(myFrame, "The game is running! You can't do that.");
        });

        removePlayer.addActionListener(e -> {
            if (!session_started) {
                String playerData=JOptionPane.showInputDialog(myFrame, "Introduce the player's name:");
                if(playerData!=null){
                    if (table.removePlayer(table.initiatePlayer(playerData)) == 1) {
                        JOptionPane.showMessageDialog(myFrame, "The player has been removed!");
                        playerListPane.setText(table.playerListToText());
                    } else JOptionPane.showMessageDialog(myFrame, "The player couldn't be removed!");
                }
            } else JOptionPane.showMessageDialog(myFrame, "The game is running! You can't do that.");
        });

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.playerList.size() < 2) {
                    JOptionPane.showMessageDialog(myFrame, "Sorry to say but you need friends to play this game - (player count is too low)");
                } else {
                    session_started = true;
                    startGame.setVisible(false);
                    resetGame.setVisible(true);
                    table.startPhase(); //aici sa implementez gameplayu iar in cealalta parte implementez o faza doar aici e main shit
                }
            }
        });

        resetGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.resetGame();
                rolledDice = 0;
                session_started = false;

                startGame.setVisible(true);
                resetGame.setVisible(false);

                //reset the info shown in the money,name,playerList panes
                playerListPane.setText("Player List: ");
                playerMoneyPane.setText("Player Funds: ");
                playerNamePane.setText("Player Name: ");
            }
        });

        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (session_started) {
                    rolledDice = table.rollDice();
                    diceValuePane.setText("Player " + table.playerList.get(table.playerTurn).getPlayerName()
                            + "->   Dice Value: " + rolledDice + " (" + table.combinations(rolledDice) + " ) ");
                } else
                    JOptionPane.showMessageDialog(myFrame, "Start the game first! Click the \"Menu\" button to do so.");

            }
        });

        enterPlayerMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
