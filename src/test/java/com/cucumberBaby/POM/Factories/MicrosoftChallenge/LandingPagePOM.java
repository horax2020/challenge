package com.cucumberBaby.POM.Factories.MicrosoftChallenge;

import com.cucumberBaby.Config.ReadPropertyFiles;
import com.cucumberBaby.POM.Factories.mapBasePOM;

public class LandingPagePOM extends mapBasePOM {

    public void setRegionMSChallenge() {
        mapBasePOM.region = new ReadPropertyFiles("prod_chl1");
    }

    public void reachLandingPage(){
        driver.get(region.valueProperty);
    }

    public boolean isLandingPage(){

        System.out.print(landingPageMap.driver.getTitle());

        if (landingPageMap.driver.getTitle().toString().equals("Microsoft - Official Home Page"))
            return true;
        else
            return false;
    }

    public boolean isWindowsPage(){

        System.out.print(landingPageMap.driver.getTitle());

        if (landingPageMap.driver.getTitle().toString().equals("Explore Windows 10 OS, Computers, Apps, & More | Microsoft"))
            return true;
        else
            return false;
    }


    public boolean isMicrosoft365(){
        return find(landingPageMap.microsoft365NavElement);

    }

    public boolean isOffice(){
        return find(landingPageMap.officeNavElement);
    }

    public boolean isWindows(){
        return find(landingPageMap.windowsNavElement);
    }

    public boolean isSurface(){
        return find(landingPageMap.surfaceNavElement);
    }
    public boolean isXbox(){
        return find(landingPageMap.xboxNavElement);
    }

    public boolean isDeals(){
        return find(landingPageMap.dealsNavElement);
    }

    public boolean isSupport(){
        return find(landingPageMap.supportNavElement);
    }

    public boolean isLandingPageNavBar(){
        return (   isMicrosoft365()
                && isOffice()
                && isWindows()
                && isSurface()
                && isXbox()
                && isDeals()
                && isSupport());
    }

    public boolean reachWindowsPage() {
        clickElement(landingPageMap.windowsNavElement);
        return(isWindowsPage());
    }

    public boolean isWindows10Menu() {


        return false;
    }
    public boolean showWindowsMenu() {

        clickElement(landingPageMap.windows10NavElement);

        if (find(landingPageMap.windows10ContextMenuElement)) {

            landingPageMap.windows10ContextNavElement.forEach((e) -> {
                //find(e);
                System.out.println(e.getText().toString());

                }

            );
            return true;

        } else
        return false;
    }

    public boolean showSearchResults(String valToSearch) {
        if (boolClickElement(landingPageMap.searchMagnifier)) {

            if (boolClickElement(landingPageMap.searchInputBar))
            {
                writeText(landingPageMap.searchInputBar, valToSearch);
                clickElement(landingPageMap.searchMagnifier);

                clickElement(landingPageMap.marketCancel);

            } else return false;

            return true;
        }
        return false;
    }
}
