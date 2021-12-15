package com.demandbridge.single;

import com.demandbridge.single.pages.Administration;
import com.demandbridge.single.pages.DistributorReportsOne;
import com.demandbridge.single.pages.DistributorReportsTwo;
import com.demandbridge.single.pages.Setup;
import org.testng.annotations.Test;

public class DistributorSetup {

    @Test
    public void distributorSetupTest(){

        new Administration().administrationTest();
        new DistributorReportsOne().distributorReportsOneTest();
        new DistributorReportsTwo().distributorReportsTwoTest();
        new Setup().setupTest();
    }
}
