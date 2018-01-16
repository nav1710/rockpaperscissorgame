import enums.RuleEnum;
import models.Player;
import org.junit.Before;
import org.junit.Test;
import service.RockPaperScissorsService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RockPaperScissorsTest
{
    private RockPaperScissorsService service;

    private Player playerA, playerB;

    private Integer rounds = 100;

    private StringBuilder stringBuilder;

    @Before
    public void setupTestData() throws Exception
    {
        playerA = new Player("Jade", RuleEnum.ROCK);
        playerB = new Player("Jean", RuleEnum.SCISSOR);

        service = new RockPaperScissorsService(rounds, playerA, playerB);
        service.startGame();

        stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\"models.Player %s wins %d of %d games\"\n", playerA.getName(), playerA.getWins(), rounds));
        stringBuilder.append(String.format("\"models.Player %s wins %d of %d games\"\n", playerB.getName(), playerB.getWins(), rounds));
        stringBuilder.append(String.format("\"Tie: %d of %d games\"", service.getDrawRounds(), rounds));
    }

    @Test
    public void outputMessageTest() throws Exception
    {
        String outputMessage = RockPaperScissors.outputMessage(service, playerA, playerB);

        assertThat(outputMessage, is(stringBuilder.toString()));
    }
}
