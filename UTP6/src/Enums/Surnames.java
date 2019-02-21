package Enums;

import java.util.Random;

public enum Surnames {

        sur1("James"),
        sur2("Scott"),
        sur3("Smith"),
        sur4("Green"),
        sur5("Banner"),
        sur6("Geller"),
        sur7("Bing"),
        sur8("Tribiani"),
        sur9("Oldman");

        private final String text;

        Surnames(final String te){
            text = te;
        }

        public static Enums.Surnames random() {
            Random r = new Random();
            return Enums.Surnames.values()[r.nextInt(Enums.Names.values().length)];
        }
        @Override
        public String toString() {
            return text;
        }
    }
