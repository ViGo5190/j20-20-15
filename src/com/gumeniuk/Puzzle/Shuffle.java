package com.gumeniuk.Puzzle;

import java.util.List;
import java.util.Random;

public class Shuffle implements Runnable {
    private final List<GameButton> buttons;

    private Random random = new Random();

    public Shuffle(List<GameButton> buttons) {
        this.buttons = buttons;
    }

    private GameButton next() {
        return buttons.get(random.nextInt(buttons.size()));
    }

    private void swap(GameButton a, GameButton b) {
        a.moveTo(b.moveTo(a.getPosition()));
    }

    @Override
    public void run() {
        int i = random.nextInt(30);
        while (i-- > 0) {
            swap(next(), next());
        }
    }
}
