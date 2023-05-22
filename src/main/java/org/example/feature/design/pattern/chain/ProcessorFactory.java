package org.example.feature.design.pattern.chain;

import java.util.*;

public class ProcessorFactory {

    private static Map<Integer, VerifyProcessor> map = new HashMap<>();

    static {
        for (ProcessorEnum processorEnum : ProcessorEnum.values()) {
            VerifyProcessor verifyProcessor = processorEnum.getVerifyProcessor();
            map.put(processorEnum.getOrder(), verifyProcessor);
        }
    }
    public static VerifyProcessor getFirstProcessor() {
        VerifyProcessor dummy = ProcessorEnum.ONE_PROCESSOR.getVerifyProcessor();
        VerifyProcessor next = dummy;
        for (ProcessorEnum pEnum : ProcessorEnum.values()) {
            next.setNext(pEnum.getVerifyProcessor());
            next = dummy.next;
        }

        return dummy.next;
    }
}
