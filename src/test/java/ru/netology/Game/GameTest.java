package ru.netology.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player ivan = new Player(1, "Иван", 120);
        Player kolya = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(kolya);

        int actual = game.round("Иван", "Коля");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player ivan = new Player(1, "Иван", 120);
        Player kolya = new Player(1, "Коля", 150);
        Game game = new Game();

        game.register(ivan);
        game.register(kolya);

        int actual = game.round("Иван", "Коля");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNobodyWin() {
        Player ivan = new Player(1, "Иван", 100);
        Player kolya = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(kolya);

        int actual = game.round("Иван", "Коля");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstNotExist() {
        Player ivan = new Player(1, "Иван", 100);
        Player kolya = new Player(1, "Коля", 120);
        Game game = new Game();

        game.register(ivan);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Маша", "Коля"));
    }

    @Test
    public void testWhenSecondNotExist() {
        Player ivan = new Player(1, "Иван", 100);
        Player kolya = new Player(1, "Коля", 120);
        Game game = new Game();

        game.register(ivan);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Иван", "Саша"));
    }


}
