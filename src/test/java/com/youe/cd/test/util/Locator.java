package com.youe.cd.test.util;

public class Locator {

    public enum ByType {
        xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName
    }

    private ByType byType;

    private String locatorName;
    private String element;
    private int waitSec;

    public Locator() {

    }

    public Locator(String element) {
        this.element = element;
        this.waitSec = 3;
        this.byType = ByType.xpath;
    }

    public Locator(String element, int waitSec) {
        this.waitSec = waitSec;
        this.element = element;
        this.byType = ByType.xpath;
    }

    public Locator(String element, int waitSec, ByType byType) {
        this.waitSec = waitSec;
        this.element = element;
        this.byType = byType;
    }

    public Locator(String element, int waitSec, ByType byType, String locatorName) {
        this.waitSec = waitSec;
        this.element = element;
        this.byType = byType;
        this.locatorName = locatorName;
    }


    public String getElement() {
        return element;
    }

    public int getWaitSec() {
        return waitSec;
    }

    public ByType getByType() {
        return byType;
    }

    public void setByType(ByType byType) {
        this.byType = byType;
    }

    public String getLocalorName() {
        return locatorName;
    }

}