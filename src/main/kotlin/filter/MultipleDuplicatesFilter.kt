package filter

interface MultipleDuplicatesFilter<E> {
    fun filterMultipleDuplicates(list: List<E>, num: Int): List<E>
}