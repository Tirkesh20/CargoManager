package tur.tkey.CargoManager.validator;

import java.util.function.Predicate;

public class DefaultAuthValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return true;
    }
//todo
}
