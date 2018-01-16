import enums.RuleEnum;
import models.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import service.RockPaperScissorsService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RockPaperScissorsServiceTests
{
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private RockPaperScissorsService service;

    private Player playerA, playerB;

    private Integer rounds = 100;

    @Before
    public void setupTestData()
    {
        playerA = new Player("Jade", RuleEnum.ROCK);
        playerB = new Player("Jean", null);
    }

    @Test
    public void playerCreationEmptyNameTestThrows() throws Exception
    {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Player name cannot be null or empty");

        Player playerC = new Player(" ", null);
        service = new RockPaperScissorsService(rounds, playerA, playerC);
        service.startGame();
    }

    @Test
    public void playerCreationNullNameTestThrows() throws Exception
    {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Player name cannot be null or empty");

        Player playerC = new Player(null, null);
        service = new RockPaperScissorsService(rounds, playerA, playerC);
        service.startGame();
    }

    @Test
    public void testStartGameTest() throws Exception
    {
        rockPaperScissorsService = new RockPaperScissorsService(rounds, playerA, playerB);
        rockPaperScissorsService.startGame();

        int totalRoundsPlayed = playerA.getWins() + playerB.getWins()+ rockPaperScissorsService.getDrawRounds();

        assertThat(totalRoundsPlayed, is(100));
    }

    @Test
    public void testStartGameTestRes() throws Exception
    {
        rockPaperScissorsService = new RockPaperScissorsService(1, playerA, playerB);
        rockPaperScissorsService.startGame();

        int totalRoundsPlayed = playerA.getWins() + playerB.getWins()+ rockPaperScissorsService.getDrawRounds();

        if(playerA.getWins() == 1)
        {
            assertThat(playerB.getShape(), is(RuleEnum.SCISSOR));
        }
        else if(playerB.getWins() == 1)
        {
            assertThat(playerB.getShape(), is(RuleEnum.PAPER));
        }

        assertThat(totalRoundsPlayed, is(1));
    }
}
