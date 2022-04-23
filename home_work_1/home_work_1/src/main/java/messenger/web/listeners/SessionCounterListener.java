package messenger.web.listeners;

import messenger.service.StatisticService;
import messenger.service.api.IStatisticService;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionCounterListener implements HttpSessionAttributeListener {
    private static final IStatisticService statisticService = StatisticService.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        statisticService.incrementCounter();
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        statisticService.decrementCounter();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }


}
