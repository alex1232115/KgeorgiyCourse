package introduction.bitOperators;

public class Main {
    public static void main(String[] args) {
        /* побитовый сдвиг вправо >> */

//        int i = 0b100;
//        System.out.println(i);
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println("Быстрое деление на 2: " + (i >> 1));
//
//        int b1 = 0b00001001;
//        int b2 = 0b00001010;
//        printBinary(b1);
//        printBinary(b2);
//        /* Побитовое И (AND) */
//        System.out.println("(AND)");
//        printBinary(b1 & b2);
//
//        /* Побитовое ИЛИ (OR) */
//        System.out.println("(OR)");
//        printBinary(b1 | b2);
//
//        /* Исключающее ИЛИ (XOR) */
//        System.out.println("(XOR)");
//        printBinary(b1 ^ b2);
//
//        /* Инверсия (NOT) */
//        System.out.println("(NOT)");
//        printBinary(~b1);
//
//        int b = 0b11011000;
//        System.out.println(b);
//        System.out.println(b | 0b00000010);
//
//        System.out.println((b & 0b00001000) > 0 ? "1" : "0");

        //color();
        BitArray bitArray = new BitArray(10);
        bitArray.set(0, 1);
        bitArray.set(9, 1);
        bitArray.set(5, 1);
        bitArray.set(5, 0);

        System.out.println(bitArray);
    }

    public static void printBinary(int b) {
        System.out.println("0b" + Integer.toBinaryString(0b100000000 | (b &  0xff)).substring(1));
    }

    public static void color() {
        int r = 64;
        int g = 128;
        int b = 32;
        int alpha = 255;
        int color = alpha << 24 | r << 16 | g << 8 | b;
        System.out.println(Integer.toBinaryString(color));

        int b1 = color & 0xFF;
        int b2 = (color & 0xFF << 8) >> 8;
        int b3 = (color & 0xFF << 16) >> 16;
        int b4 = (color & 0xFF << 24) >> 24;
        printBinary(b1);
        printBinary(b2);
        printBinary(b3);
        printBinary(b4);
    }

    public static class BitArray {
        int size;
        byte[] bytes;

        private byte[] masks = new byte[] {0b00000001, 0b00000010, 0b00000100, 0b00001000,
                0b00010000, 0b00100000, 0b01000000, (byte) 0b10000000};

        public BitArray(int size) {
            this.size = size;
            int sizeInBytes = size / 8;
            if (size % 8 > 0) {
                sizeInBytes = sizeInBytes + 1;
            }
            bytes = new byte[sizeInBytes];
        }

        public int get(int index) {
            int byteIndex = index / 8;
            int bitIndex = index  % 8;
            return (bytes[byteIndex] ^ masks[bitIndex]) > 0 ? 1: 0;
        }

        public void set (int index, int value) {
            int byteIndex = index / 8;
            int bitIndex = index  % 8;

            if (value > 0) {
                bytes[byteIndex] = (byte) (bytes[byteIndex] | masks[bitIndex]);
            } else {
                bytes[byteIndex] = (byte) (bytes[byteIndex] & ~masks[bitIndex]);
            }
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(get(i) > 0 ? '1' : '0');
            }
            return sb.toString();
        }
    }
}
