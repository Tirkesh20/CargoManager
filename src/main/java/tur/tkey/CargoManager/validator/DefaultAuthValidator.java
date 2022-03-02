package tur.tkey.CargoManager.validator;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
//todo
public class DefaultAuthValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return true;
        //todo
    }

}
