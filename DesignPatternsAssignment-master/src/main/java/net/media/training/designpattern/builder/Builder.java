package net.media.training.designpattern.builder;

public interface Builder {
    public Builder setName(String name);
    public Builder setCity(String city);
    public Builder setId(int id);
    public Builder setCountry(String country);
}