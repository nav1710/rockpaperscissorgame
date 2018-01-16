package enums;

public enum RuleEnum implements EnumCodes<RuleEnum>
{
    ROCK(0, "R"),
    PAPER(1, "P"),
    SCISSOR(2, "S");

    private final int value;
    private final String code;

    private RuleEnum beats;

    static
    {
        ROCK.beats = RuleEnum.SCISSOR;
        PAPER.beats = RuleEnum.ROCK;
        SCISSOR.beats = RuleEnum.PAPER;
    }

    RuleEnum(int value, String code)
    {
        this.value = value;
        this.code = code;
    }

    public int getValue()
    {
        return value;
    }

    public String getCode()
    {
        return code;
    }

    public RuleEnum getBeats()
    {
        return beats;
    }

    public static RuleEnum fromValue(int id) throws Exception
    {
        switch(id)
        {
            case 0:
                return ROCK;
            case 1:
                return PAPER;
            case 2:
                return SCISSOR;
            default:
                throw new IllegalArgumentException("Not a valid id for enum");
        }
    }

    public static RuleEnum fromCode(String code) throws Exception
    {
        if (code.equalsIgnoreCase("R"))
            return ROCK;
        else if (code.equalsIgnoreCase("P"))
            return PAPER;
        else if (code.equalsIgnoreCase("S"))
            return SCISSOR;
        else
            throw new IllegalArgumentException("Not a valid code for enum");
    }
}
