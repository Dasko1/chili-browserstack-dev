package com.demandbridge.single;

import com.codeborne.selenide.Selenide;
import com.demandbridge.single.pages.*;
import org.testng.annotations.Test;

public class EQCDistributorSetup {

    @Test
    public void eqcDistributorSetupTest(){
         new ItemPropertiesRestrictionsEQC().itemPropertiesRestrictionsEQCTest();
         new ItemRestrictionsRickyEastEQC().itemRestrictionsRickyEastEQCTest();
         new EQItemRestrictionsPage().eqItemsRestricionsPageTest();
         new ItemRestrictionsSandraNorthEQC().itemRestrictionsSandraNorthEQCTest();
         new ItemRestrictionsTobyWestEQC().itemRestrictionsTobyWestEQCTest();
         new ItemRestrictionsStacyAllDirectionsEQC().itemRestrictionsStacyAllDirectionsEQCTest();


        // Uncheck and reset
        Selenide.sleep(2500);
        new ItemPropertiesRestrictionsEQCReset().itemPropertiesRestrictionsEQCReset();

    }


}
