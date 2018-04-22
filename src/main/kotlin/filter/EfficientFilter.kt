package filter

class EfficientFilter<E> : MultipleDuplicatesFilter<E> {
    override fun filterMultipleDuplicates(list: List<E>, num: Int): List<E> {
        val duplicates: MutableMap<E, Int> = HashMap()
        list.forEach {
            duplicates.compute(it) { _, prevVal ->
                if (prevVal != null) prevVal + 1 else 1
            }
        }
        val filteredDuplicates = duplicates.filter { it.value >= num }
        return list.filter { !filteredDuplicates.contains(it) }
    }
}