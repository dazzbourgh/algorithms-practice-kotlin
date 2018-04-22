package filter

import filter.EfficientFilter
import filter.MultipleDuplicatesFilter
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class MultipleDuplicatesTest: Spek({
    describe("efficient filter") {
        val filter: MultipleDuplicatesFilter<Int> = EfficientFilter()
        val list: List<Int> = listOf(1, 2, 2, 2, 4, 4, 5, 6, 6)
        val expectedList = listOf(1, 4, 4, 5, 6, 6)
        it("should remove elements more frequent than N") {
            val filteredList = filter.filterMultipleDuplicates(list, 3)
            assertEquals(expectedList, filteredList)
        }
    }
})