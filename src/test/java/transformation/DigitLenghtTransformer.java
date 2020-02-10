package transformation;

import cucumber.api.Transformer;

public class DigitLenghtTransformer extends Transformer<Integer> {

    @Override
    public Integer transform(String salary) {
        return salary.length();
    }
}
