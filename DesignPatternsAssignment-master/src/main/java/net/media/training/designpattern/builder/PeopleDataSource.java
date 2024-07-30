package net.media.training.designpattern.builder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 10:04:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleDataSource {
    public static String getPeopleXml(List<Person> persons) {
        String finalXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        finalXML += "<People number=\"" + persons.size() + "\">";
        XMLBuilder xmlBuilder = new XMLBuilder();
        for (Person person : persons) {
            finalXML += xmlBuilder.setPerson(person).build();
        }
        finalXML += "</People>";
        return finalXML;
    }
}