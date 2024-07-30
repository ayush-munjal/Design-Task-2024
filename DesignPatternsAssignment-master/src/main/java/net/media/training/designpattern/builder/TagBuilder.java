package net.media.training.designpattern.builder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TagBuilder {
    String tagname;
    HashMap<String,String> attributes = new LinkedHashMap<>();
    String value;

    public TagBuilder setTagName(String tagname){
        this.tagname = tagname;
        return this;
    }
    public TagBuilder setAttribute(String attribute, String value){
        this.attributes.put(attribute,value);
        return this;
    }
    public TagBuilder setvalue(String value){
        this.value = value;
        return this;
    }

    public String build(){
        String tag = "";
        tag += "<" + tagname;

        for (Map.Entry<String,String> mapElement : attributes.entrySet()) {
            String attr = mapElement.getKey();
            String value = mapElement.getValue();
            tag += " " + attr + "=\"" + value + "\"";
        }
        tag += ">";
        tag += value;
        tag += "</" + tagname + ">";
        return tag;
    }
}
