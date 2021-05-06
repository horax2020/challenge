package com.cucumberBaby.POM.Factories.MicrosoftChallenge;

import com.cucumberBaby.POM.Factories.mapBasePOM;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CartPagePOM extends mapBasePOM {

    public boolean validatePrices(){

        clickElement(itemDetailsMap.addToCartItemElement);

        System.out.println("LOG:Compare:"+crossScenarioValues.get(itemPriceDetail)+ " == "+ crossScenarioValues.get(itemPriceSearch));

        System.out.println("LOG:Item price:" + cartPageMap.priceItemElement.getText());
        System.out.println("LOG:Subtotal:" + cartPageMap.subtotalSummaryElement.getText());
        System.out.println("LOG:Total:" + cartPageMap.totalSummaryElement.getText());

        crossScenarioValues.put(itemPriceCart, cartPageMap.priceItemElement.getText());
        crossScenarioValues.put(itemSubtotalCart, cartPageMap.subtotalSummaryElement.getText());
        crossScenarioValues.put(itemTotalCart, cartPageMap.totalSummaryElement.getText());

        if  (crossScenarioValues.get(itemPriceCart).equals(crossScenarioValues.get(itemSubtotalCart))
             &&
             crossScenarioValues.get(itemTotalCart).equals(crossScenarioValues.get(itemPriceDetail))) {
            return true;
        } else return false;


    }

    public boolean validateQuantity(){

        selectFromDDByText(cartPageMap.qtySelectorElement, "20");

        mySleep(5);

        find(cartPageMap.priceItemElement);

        crossScenarioValues.put(itemPriceCart, cartPageMap.priceItemElement.getText());
        crossScenarioValues.put(itemSubtotalCart, cartPageMap.subtotalSummaryElement.getText());
        crossScenarioValues.put(itemTotalCart, cartPageMap.totalSummaryElement.getText());

        Locale locale = Locale.US;
        Number numberItemPrice = null;
        Number numberItemSubtotal = null;
        Number numberItemTotal = null;

        try {
            numberItemPrice = NumberFormat.getCurrencyInstance(locale).parse(crossScenarioValues.get(itemPriceDetail).toString());
            numberItemSubtotal = NumberFormat.getCurrencyInstance(locale).parse(crossScenarioValues.get(itemSubtotalCart).toString());
            numberItemTotal = NumberFormat.getCurrencyInstance(locale).parse(crossScenarioValues.get(itemTotalCart).toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(numberItemPrice);

        float itemPrice = Float.parseFloat(numberItemPrice.toString()) * 20;
        float itemSubtotal = Float.parseFloat(numberItemSubtotal.toString());
        float itemTotal = Float.parseFloat(numberItemTotal.toString());

        System.out.println("LOG:Prices calculation:Item Price:"+ itemPrice);
        System.out.println("LOG:Prices calculation:Subtotal:"+ itemSubtotal);
        System.out.println("LOG:Prices calculation:Total:"+ itemTotal);

        return ((itemPrice == itemSubtotal) && (itemSubtotal == itemTotal));

    }
}
