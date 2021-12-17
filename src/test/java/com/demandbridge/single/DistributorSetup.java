package com.demandbridge.single;

import com.demandbridge.single.pages.*;
import org.testng.annotations.Test;

public class DistributorSetup {

    @Test
    public void distributorSetupTest(){

        new Administration().administrationTest();
        new DistributorReportsOne().distributorReportsOneTest();
        new DistributorReportsTwo().distributorReportsTwoTest();
        new Setup().setupTest();
        new SiteAppearance().siteAppearanceTest();
        new Templates().templatesTest();
    }
}
