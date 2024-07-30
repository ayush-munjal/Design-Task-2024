package net.media.training.designpattern.adapter.thirdparty;

import net.media.training.designpattern.adapter.Employee;
import net.media.training.designpattern.adapter.LeaveRecord;

public class ThirdPartyLeaveRecordAdapter implements LeaveRecord{
    private ThirdPartyLeaveRecord thirdpartyleaverecord;

    public ThirdPartyLeaveRecordAdapter(ThirdPartyLeaveRecord thirdpartyleaverecord){
        this.thirdpartyleaverecord = thirdpartyleaverecord;
    }

    public String getMostAbsentEmployee(){
        String name =  this.thirdpartyleaverecord.getMostAbsentEmployee().getName();
        String[] splited = name.split(", ");
        String newName = splited[1] + " " + splited[0];
        return newName;
    }

    public int getEmployeeAbsences(String employeeName){
        String[] splited = employeeName.split(" ");
        String firstname = String.join(" ", java.util.Arrays.copyOf(splited, splited.length-1)); 
        return this.thirdpartyleaverecord.getEmployeeAbsences(new Employee(splited[splited.length-1]+ ", " + firstname));
    }
}
