public class GenericsMinMaxDemo {
    public static void main(String[] args) {
        Integer[] intArray = {3, 5, 7, 2, 8};
        String[] strArray = {"apple", "orange", "banana", "grape"};
        Character[] charArray = {'z', 'a', 'm', 'k'};
        Float[] floatArray = {2.5f, 1.2f, 9.8f, 3.4f};

        MinMaxImpl<Integer> intMinMax = new MinMaxImpl<>(intArray);
        MinMaxImpl<String> strMinMax = new MinMaxImpl<>(strArray);
        MinMaxImpl<Character> charMinMax = new MinMaxImpl<>(charArray);
        MinMaxImpl<Float> floatMinMax = new MinMaxImpl<>(floatArray);

        System.out.println("Integer Min: " + intMinMax.min() + ", Max: " + intMinMax.max());
        System.out.println("String Min: " + strMinMax.min() + ", Max: " + strMinMax.max());
        System.out.println("Character Min: " + charMinMax.min() + ", Max: " + charMinMax.max());
        System.out.println("Float Min: " + floatMinMax.min() + ", Max: " + floatMinMax.max());
    }
}
