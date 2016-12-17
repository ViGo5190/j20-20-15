package com.gumeniuk.Puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Dashboard extends AbstractFrame {

    private final List<GameButton> buttons;
    private final Runnable shuffle;

    private int empty;
    private static int size;

    Dashboard() throws HeadlessException {

        size = empty = GameButton.DIMENSION * GameButton.DIMENSION - 1;
        this.buttons = new ArrayList<>();

        ActionListener listener = getActionListenerImpl();
        for (int i = 0; i < size; i++) {
            buttons.add(new GameButton(i, listener));
        }

        shuffle = new Shuffle(buttons);
        shuffle.run();
    }

    public static void main(String[] args) {
        initLookAndFeel();

        new Dashboard().setVisible(true);
    }

    @Override
    protected void onInit() {
        setTitle("Puzzle");
        setLayout(null);
        setResizable(false);

        int size = GameButton.size * GameButton.DIMENSION;
        getContentPane().setPreferredSize(new Dimension(size, size));

        for (JButton button : buttons) {
            add(button);
        }
        pack();
    }

    @Override
    protected void onButtonClick(JButton src) {
        GameButton button = (GameButton) src;
        if (button.canMoveTo(empty)) {
            empty = button.moveTo(empty);
            if (hasWin()) {
                showMessage("Congratulations", "You won!");
                shuffle.run();
            }
        }
    }

    private boolean hasWin() {
        for (GameButton btn : buttons) {
            if (!btn.hasValidPosition()) {
                return false;
            }
        }
        return true;
    }
}
