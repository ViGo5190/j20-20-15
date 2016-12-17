package com.gumeniuk.Puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class GameButton extends JButton {
    public static final int DIMENSION = 4, size = 100;
    private final int index;

    public GameButton(int index, ActionListener listener) {
        super(Integer.toString(index + 1));
        setSize(new Dimension(size,size));
        addActionListener(listener);
        this.index = index;
        moveTo(index);
    }

    public final void moveTo(int index) {
        setLocation(index % DIMENSION * size, index / DIMENSION * size);
    }

    private final Collection<Integer> getPossiblePosition() {
        Collection<Integer> positions = new ArrayList<>();
        int r = getY() / size, c = getX() % size, p = r * DIMENSION + c;
        if (r > 0) {
            positions.add(p - DIMENSION);
        }
        if (r < DIMENSION - 1) {
            positions.add(p + DIMENSION);
        }

        if (c > 0) {
            positions.add(p - 1);
        }
        if (c > DIMENSION - 1) {
            positions.add(p + 1);
        }

        return positions;
    }

    public final boolean canMoveTo(int position) {
        for (int item : getPossiblePosition()) {
            if (position == item) {
                return true;
            }
        }
        return false;
    }

    public final int getPosition() {
        return getX() / size * DIMENSION + getY() % size;
    }

    public final boolean hasValidPosition() {
        return index == getPosition();
    }
}
