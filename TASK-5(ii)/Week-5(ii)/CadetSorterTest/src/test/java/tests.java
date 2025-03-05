public class CadetSorterTest {

    @Test
    void testEmptyList() {
        List<Cadet> cadets = Arrays.asList();
        CadetSorter.sortCadets(cadets);
        assertTrue(cadets.isEmpty(), "The cadet list should be empty.");
    }

    @Test
    void testSingleCadet() {
        List<Cadet> cadets = Arrays.asList(new Cadet("Alice"));
        CadetSorter.sortCadets(cadets);
        assertEquals(1, cadets.size(), "There should be exactly one cadet.");
        assertEquals("Alice", cadets.get(0).getName(), "The single cadet should be Alice.");
    }

    @Test
    void testMultipleCadets() {
        List<Cadet> cadets = Arrays.asList(new Cadet("Alice"), new Cadet("Charlie"), new Cadet("Bob"));
        CadetSorter.sortCadets(cadets);
        assertEquals("Alice", cadets.get(0).getName(), "The first cadet should be Alice.");
        assertEquals("Bob", cadets.get(1).getName(), "The second cadet should be Bob.");
        assertEquals("Charlie", cadets.get(2).getName(), "The third cadet should be Charlie.");
    }

    @Test
    void testCadetsWithIdenticalNames() {
        List<Cadet> cadets = Arrays.asList(new Cadet("Alice"), new Cadet("Alice"), new Cadet("Bob"));
        CadetSorter.sortCadets(cadets);
        assertEquals("Alice", cadets.get(0).getName(), "The first cadet should be Alice.");
        assertEquals("Alice", cadets.get(1).getName(), "The second cadet should be Alice.");
        assertEquals("Bob", cadets.get(2).getName(), "The third cadet should be Bob.");
    }

    @Test
    void testAlreadySortedList() {
        List<Cadet> cadets = Arrays.asList(new Cadet("Alice"), new Cadet("Bob"), new Cadet("Charlie"));
        CadetSorter.sortCadets(cadets);
        assertEquals("Alice", cadets.get(0).getName(), "The first cadet should be Alice.");
        assertEquals("Bob", cadets.get(1).getName(), "The second cadet should be Bob.");
        assertEquals("Charlie", cadets.get(2).getName(), "The third cadet should be Charlie.");
    }

    @Test
    void testReversedList() {
        List<Cadet> cadets = Arrays.asList(new Cadet("Charlie"), new Cadet("Bob"), new Cadet("Alice"));
        CadetSorter.sortCadets(cadets);
        assertEquals("Alice", cadets.get(0).getName(), "The first cadet should be Alice.");
        assertEquals("Bob", cadets.get(1).getName(), "The second cadet should be Bob.");
        assertEquals("Charlie", cadets.get(2).getName(), "The third cadet should be Charlie.");
    }
}