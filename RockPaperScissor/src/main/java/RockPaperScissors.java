import enums.RuleEnum;
import models.Player;
import service.RockPaperScissorsService;

public class RockPaperScissors
{
    private static Player playerA, playerB;

    private static final int rounds = 100;

    public static void main(String args[]) throws Exception
    {
        //create player with shape = PAPER
        playerA = new Player("A", RuleEnum.PAPER);

        //create player with shape = null. Shape gets calculated randomly in startGame()
        playerB = new Player ("B", null);

        //initialize the rockPaperScissorsService with both players and number of rounds
        RockPaperScissorsService service = new RockPaperScissorsService(rounds, playerA, playerB);

        //start the rockPaperScissorsService
        service.startGame();

        //print final results of the rockPaperScissorsService
        System.out.println(outputMessage(service, playerA, playerB));
    }

    public static String outputMessage(RockPaperScissorsService rockPaperScissorsService, Player playerA, Player playerB)
    {
        StringBuilder build = new StringBuilder();
        build.append(String.format("\"models.Player %s wins %d of %d games\"\n", playerA.getName(), playerA.getWins(), rounds));
        build.append(String.format("\"models.Player %s wins %d of %d games\"\n", playerB.getName(), playerB.getWins(), rounds));
        build.append(String.format("\"Tie: %d of %d games\"", rockPaperScissorsService.getDrawRounds(), rounds));

        return build.toString();
    }
}
