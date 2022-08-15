package ru.timdev.junit;

import org.jetbrains.annotations.NotNull;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import ru.timdev.junit.service.UserServiceTest;

import java.io.PrintWriter;
import java.util.Iterator;

public class TestLauncher implements Comparable{
    public static void main(String[] args) {
        var launcher = LauncherFactory.create();
//        launcher.registerLauncherDiscoveryListeners();

        var summaryGeneratingListener = new SummaryGeneratingListener();

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectClass(UserServiceTest.class))
                .selectors(DiscoverySelectors.selectPackage("ru.timdev.junit.service"))
//                .listeners()
                .build();
        launcher.execute(request, summaryGeneratingListener);
        try (var printWriter = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(printWriter);
        }
    }

    @Override
    public int compareTo(@NotNull Object o) {
        //Iterator
        return 0;
    }

}
