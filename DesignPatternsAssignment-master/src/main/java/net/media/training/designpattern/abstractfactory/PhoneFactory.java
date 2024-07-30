package net.media.training.designpattern.abstractfactory;

public interface PhoneFactory {
    public MotherBoard createMotherBoard();
    public Screen createScreen();
    public Case createCase();
}
