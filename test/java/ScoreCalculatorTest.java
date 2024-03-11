import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class ScoreCalculatorTest {

    @Test
    public void testNoCardScore(){

        Player player = new Player("Test");

        int score = player.getScore();

        assertEquals(score, 0);

    }

    @Test
    public void testSingleCardScore() {

        Player player = new Player ("Test");

        player.getHand().add(new Card(Suite.CLUBS,Face.JACK, 10, false));

        int score = player.getScore();

        assertEquals(score, 10);

    }
    @Test
    public void testMultipleCardScore() {

        Player player = new Player ("Test");

        player.getHand().add(new Card(Suite.CLUBS,Face.JACK, 10, false));
        player.getHand().add(new Card(Suite.SPADES,null, 7, false));
        player.getHand().add(new Card(Suite.HEARTS,null, 1, true));

        int score = player.getScore();

        assertEquals(score, 18);
    }

    @Test
    public void testMultipleAceScore() {
        Player player = new Player ("Test");

        player.getHand().add(new Card(Suite.CLUBS,Face.JACK, 5, false));
        player.getHand().add(new Card(Suite.SPADES,null, 11, true));
        player.getHand().add(new Card(Suite.HEARTS,null, 11, true));

        int score = player.getScore();

        assertEquals(score, 17);

    }

    @Test
    public void testAllAceScore() {
        Player player = new Player ("Test");

        player.getHand().add(new Card(Suite.CLUBS,null, 11, true));
        player.getHand().add(new Card(Suite.SPADES,null, 11, true));
        player.getHand().add(new Card(Suite.HEARTS,null, 11, true));

        int score = player.getScore();

        assertEquals(score, 13);

    }

}
