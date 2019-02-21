package Enums;

import java.util.Random;

public enum  MessagePriority {
        HIGH("HIGH"), AVERAGE("AVERAGE"), LOW("LOW");

        private final String text;

        MessagePriority(final String te){
            text =te;
        }

        public static Enums.MessagePriority random() {
            Random r = new Random();
            return Enums.MessagePriority.values()[r.nextInt(Enums.MessagePriority.values().length)];
        }
        @Override
        public String toString() {
            return text;
        }
    }
