package e06;

public class MyTimer
{
    private long start;

    public MyTimer()
    {
        start = System.currentTimeMillis();
    }

    public long getElapsed()
    {
        return System.currentTimeMillis() - start;
    }

    public long stop()
    {
        return System.currentTimeMillis() - start;
    }

    public long go()
    {
        start = System.currentTimeMillis();
        return start;
    }
}