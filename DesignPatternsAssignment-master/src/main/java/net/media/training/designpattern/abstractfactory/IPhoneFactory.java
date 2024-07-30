package net.media.training.designpattern.abstractfactory;

public class IPhoneFactory implements PhoneFactory{
    public MotherBoard createMotherBoard(){
        return new IphoneMotherBoard();
    }
    public Screen createScreen(){
        return new IphoneScreen();
    }
    public Case createCase(){
        return new IphoneCase();
    }
    public Processor createProcessor(){
        return new IphoneProcessor();
    }
}
