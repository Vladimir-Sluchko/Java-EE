package messenger.service;

import messenger.service.api.IStatisticService;

public class StatisticService implements IStatisticService {
    private static final IStatisticService instsnce = new StatisticService();
    private int counter;
    private StatisticService(){
        this.counter = counter;

    }
    public static IStatisticService getInstance(){
        return instsnce;
    }

    @Override
    public int incrementCounter() {
        return counter++;

    }

    @Override
    public int decrementCounter() {
        return counter--;

    }

    @Override
    public int getCounter() {
        return counter;
    }
}
