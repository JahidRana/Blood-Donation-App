package com.example.blooddonation.ui.datatypes;

public class DomainUserInfo {
    public String Name;
    public String PhoneNumber;
    public String Email;
    public String Gender;
    public String BloodGroup;
    public String District;
    public String SubDistrict;
    public String Age;
    public String latitude;
    public String longitude;


    @Override
    public String toString() {
        return "DomainUserInfo{" +
                "Name='" + Name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Gender='" + Gender + '\'' +
                ", BloodGroup='" + BloodGroup + '\'' +
                ", District='" + District + '\'' +
                ", SubDistrict='" + SubDistrict + '\'' +
                ", Age='" + Age + '\'' +
                ", lat='" + latitude + '\'' +
                ", lon='" + longitude + '\'' +
                '}';
    }
}
