import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicTacToe implements ActionListener{

    //random class to tell whose turn it is
    Random random = new Random();
    JFrame frame = new JFrame(" Lucky TacToe");
    JPanel titelPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];

    //to check if it is player 1 or 2 turn
    boolean player1_Turn;
    int turns = 0;
    boolean gameover;


    TicTacToe(){
        frame.setLocation(230,20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titelPanel.setLayout(new BorderLayout());
        titelPanel.setBounds(0,0,800,100);

        buttonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttonsPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titelPanel.add(textField);
        frame.add(titelPanel,BorderLayout.NORTH);
        frame.add(buttonsPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_Turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_Turn = false;
                        textField.setText("O Turn");
                        turns++;
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_Turn = true;
                        textField.setText("X Turn");
                        turns++;
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {

       /* try {
             Thread.sleep(2000);
         } catch (InterruptedException e){
             e.printStackTrace();
         }*/

        if(random.nextInt(2)==0){
            player1_Turn = true;
            textField.setText("X's Turn");
        }
        else{
            player1_Turn = false;
            textField.setText("O's Turn");
        }
    }

    public void check() {
        // will check for X win conditions
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);

        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);

        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);

        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);

        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);

        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);

        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);

        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);

        }

        // will check for O win conditions

        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);

        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);

        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);

        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);

        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);

        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);

        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);

        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);

        }
        //gameover = true;
        //return true;
        //turns == 9
        if (turns == 9){
            for (int i = 0; i <= 8; i++) {
                buttons[i].setBackground(Color.RED);
                textField.setText("oops it's a tie!");
                buttons[i].setEnabled(false);

            }
        }
         gameover = true;
        /*if(gameover == true){
            turns = 0;*/

           // xWins(int a,int b,int c);
        //}
    }
    public void xWins(int a,int b,int c){

              buttons[a].setBackground(Color.GREEN);
              buttons[b].setBackground(Color.GREEN);
              buttons[c].setBackground(Color.GREEN);

              for(int i=0;i<9;i++){
                  buttons[i].setEnabled(false);
              }
              textField.setText("X is the Winner!!");
    }
    public void oWins(int a,int b,int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O is the winner!!");

    }

}

//Try to create the restart or retry button and make the game to run even after the game ends!

