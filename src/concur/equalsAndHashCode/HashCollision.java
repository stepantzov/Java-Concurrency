package concur.equalsAndHashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCollision {
    public static void main(String[] args) {
        Map<MyInnerClass, String> myMap = new HashMap<>();
        myMap.put(new MyInnerClass("AB", "CD"), "First");

        //Same hashCode same equals
        myMap.put(new MyInnerClass("AB", "CD"), "First");

        //Same hashCode different equals
        myMap.put(new MyInnerClass("ABC", "D"), "Second");

        System.out.println(myMap);
        System.out.println();
        System.out.println(myMap.get(new MyInnerClass("AB", "CD")));
        System.out.println(myMap.get(new MyInnerClass("ABC", "D")));
    }

    static class MyInnerClass {
        private String strA;
        private String strB;

        MyInnerClass(String strA, String strB) {
            this.strA = strA;
            this.strB = strB;
        }

        @Override
        public int hashCode() {
            return (strA + strB).length();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyInnerClass that = (MyInnerClass) o;
            return Objects.equals(strA, that.strA) && Objects.equals(strB, that.strB);
        }

        @Override
        public String toString() {
            return "MyInnerClass{" +
                    "strA='" + strA + '\'' +
                    ", strB='" + strB + '\'' +
                    '}';
        }
    }
}