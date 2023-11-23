package api.dnevnik.ru.methods;

import api.dnevnik.ru.IDnevnik;
import api.dnevnik.ru.methods.impl.DnevnikLogin;

public class DnevnikMethods {

    private final IDnevnik dnevnik;

    public DnevnikMethods(IDnevnik dnevnik) {
        this.dnevnik = dnevnik;
    }

    public DnevnikLogin login() {
        return new DnevnikLogin(dnevnik);
    }

    public IDnevnik getDnevnik() {
        return dnevnik;
    }
}
