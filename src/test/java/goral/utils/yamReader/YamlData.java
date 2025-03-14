package goral.utils.yamReader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YamlData {
    private String login;
    private String password;
    private String urlString;
    private String userName;
    private String userSurname;
    private String street;
    private String buildingNb;
    private String postOffice;
    private String postCode;
    private String city;

    public YamlData() {
    }
}
