package models;

import enums.RuleEnum;
import org.apache.commons.lang3.StringUtils;

public class Player
{
    private String name;

    private Integer wins;

    private RuleEnum shape;

    public Player(String name, RuleEnum shape)
    {
        if(name == null || StringUtils.isBlank(name))
        {
            throw new NullPointerException("Player name cannot be null or empty");
        }

        this.name = name;
        this.shape = shape;
        this.wins = 0;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getWins()
    {
        return wins;
    }

    public void setWins(Integer wins)
    {
        this.wins = wins;
    }

    public RuleEnum getShape()
    {
        return shape;
    }

    public void setShape(RuleEnum shape)
    {
        this.shape = shape;
    }

    public void incrementWins()
    {
        this.wins++;
    }
}
