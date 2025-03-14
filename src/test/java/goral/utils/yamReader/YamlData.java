package goral.utils.yamReader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YamlData {
    private String username;
    private String password;
    private String urlString;

    public YamlData() {
    }
}
