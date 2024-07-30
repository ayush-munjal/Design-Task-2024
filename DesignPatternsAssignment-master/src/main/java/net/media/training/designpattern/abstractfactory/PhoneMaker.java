package net.media.training.designpattern.abstractfactory;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 6:34:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneMaker {

    public Case buildPhone(String phoneType) {
        MotherBoard motherBoard;
        Screen screen;
        Case phoneCase;
        if(phoneType.equals("Android")){
            AndroidPhoneFactory androidPhoneFactory = new AndroidPhoneFactory();
            motherBoard = androidPhoneFactory.createMotherBoard();
            motherBoard.attachProcessor(androidPhoneFactory.createProcessor());
            screen = androidPhoneFactory.createScreen();
            phoneCase = androidPhoneFactory.createCase();
        }
        else{
            IPhoneFactory iPhoneFactory = new IPhoneFactory();
            motherBoard = iPhoneFactory.createMotherBoard();
            motherBoard.attachProcessor(iPhoneFactory.createProcessor());
            screen = iPhoneFactory.createScreen();
            phoneCase = iPhoneFactory.createCase();
        }
        motherBoard.attachBattery(new Battery());
        phoneCase.attachMotherBoard(motherBoard);
        phoneCase.attachScreen(screen);
        return phoneCase;
    }
}
