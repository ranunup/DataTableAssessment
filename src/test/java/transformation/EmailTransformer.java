package transformation;

import cucumber.api.Transformer;

public class EmailTransformer extends Transformer<String> {

    @Override
    public String transform(String email) {
        return email.concat("@zizi.com");
    }
}
