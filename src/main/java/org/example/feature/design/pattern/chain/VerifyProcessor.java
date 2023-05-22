package org.example.feature.design.pattern.chain;

/**
 * 抽象練父類
 */
public abstract class VerifyProcessor {
    protected VerifyProcessor next;

    public void setNext(VerifyProcessor next) {
        this.next = next;
    }

    // 定義實作
    public abstract int handler();
}
