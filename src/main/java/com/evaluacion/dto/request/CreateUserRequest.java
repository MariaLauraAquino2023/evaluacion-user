package com.evaluacion.dto.request;

import java.util.List;

public class CreateUserRequest {

    String name;
    String email;
    String password;
    List<Phone> phones;

    public CreateUserRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public CreateUserRequest(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                '}';
    }


    public static class Phone{
        String number;
        String cityCode;
        String countryCode;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }


        @Override
        public String toString() {
            return "Phone{" +
                    "number='" + number + '\'' +
                    ", cityCode='" + cityCode + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    '}';
        }

    }
}
