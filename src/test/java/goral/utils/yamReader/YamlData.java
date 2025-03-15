package goral.utils.yamReader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YamlData {
    private String login;
    private String password;

    private String urlString;

    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String street;
    private String buildingNb;
    private String suiteNb;
    private String postOffice;
    private String postCode;
    private String city;
    private String email;
    private String phone;
    private String orderComments;

    public YamlData() {
    }
}
