package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import com.demandbridge.BrowserStackTest;
import com.demandbridge.single.pages.*;
import org.testng.annotations.Test;

public class ItemPropertiesRestrictions extends BrowserStackTest {

    @Test
    public void itemRestrictionsTest(){

        new ItemRestrictionsRickyEast().itemRestrictionsRickyEastTest();
        new ItemRestrictionsPeterSouth().itemRestrictionsPeterSouthTest();
        new ItemRestrictionsSandraNorth().itemRestrictsionsSandraNorthTest();
        new ItemRestrictionsTobyWest().itemRestrictionsTobyWestTest();
        new ItemRestrictionsStacyAllDirections().itemRestrictionsStacyAllDirectionsTest();
        Selenide.closeWindow();
    }
}
