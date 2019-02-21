package Enums;

import java.text.Collator;
import java.util.Locale;
import java.util.Random;

public enum  Nationality {
    Polish("pl"), Ukrainian("uk"),Belarussian("be"), Slovak("sk"),
    Lithuanian("lt"), Latvian ("lv"), British ("en-GB"), Indian("en_IN"), Chinese("zh"),Vietnamese("vi");

        private final Locale _locale;
        private final Collator _collator;

        Nationality(final String te){
            _locale = new Locale(te);
            _collator = Collator.getInstance(_locale);
        }


    public static Enums.Nationality random() {
            Random r = new Random();
            return Enums.Nationality.values()[r.nextInt(Enums.Nationality.values().length)];
        }
        @Override
        public String toString() {
            return _locale.getDisplayLanguage();
        }
    }
