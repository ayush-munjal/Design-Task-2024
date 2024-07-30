package net.media.training.designpattern.abstractfactory;

public class AndroidPhoneFactory implements PhoneFactory{
    public MotherBoard createMotherBoard(){
        return new AndroidMotherBoard();
    }
    public Screen createScreen(){
        return new AndroidScreen();
    }
    public Case createCase(){
        return new AndroidCase();
    }

    public Processor createProcessor(){
        return new AndroidProcessor();
    }
}
