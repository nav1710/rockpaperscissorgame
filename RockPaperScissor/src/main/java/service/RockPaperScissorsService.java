package service;

import enums.RuleEnum;
import models.Player;

import java.util.Random;

public class RockPaperScissorsService
{
    private final Player playerA;

    private final Player playerB;

    private Integer drawRounds;

    private Integer rounds;

    public RockPaperScissorsService(Integer rounds, Player playerA, Player playerB)
    {
        this.rounds = rounds;
        this.drawRounds = 0;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void startGame() throws Exception
    {
        while(rounds>0)
        {
            Random random = new Random();
            random.nextInt(RuleEnum.values().length);

            RuleEnum playerBChoice = RuleEnum.fromValue(random.nextInt(RuleEnum.values().length));
            playerB.setShape(playerBChoice);

            if (playerA.getShape().getBeats() == playerB.getShape())
            {
                playerA.incrementWins();
            }
            else if (playerB.getShape().getBeats() == playerA.getShape())
            {
                playerB.incrementWins();
            }
            else
            {
                drawRounds++;
            }

            rounds--;
        }
    }

    public Integer getDrawRounds()
    {
        return drawRounds;
    }
}
