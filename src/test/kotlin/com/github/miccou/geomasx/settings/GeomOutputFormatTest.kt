package com.github.miccou.geomasx.settings

import junit.framework.TestCase

class GeomOutputFormatTest : TestCase() {

    fun testEnumValues() {
        val values = GeomOutputFormat.entries
        assertEquals(4, values.size)
        assertTrue(values.contains(GeomOutputFormat.WKB))
        assertTrue(values.contains(GeomOutputFormat.EWKB))
        assertTrue(values.contains(GeomOutputFormat.WKT))
        assertTrue(values.contains(GeomOutputFormat.EWKT))
    }

    fun testEnumToString() {
        assertEquals("WKB", GeomOutputFormat.WKB.toString())
        assertEquals("EWKB", GeomOutputFormat.EWKB.toString())
        assertEquals("WKT", GeomOutputFormat.WKT.toString())
        assertEquals("EWKT", GeomOutputFormat.EWKT.toString())
    }

    fun testEnumValueOf() {
        assertEquals(GeomOutputFormat.WKB, GeomOutputFormat.valueOf("WKB"))
        assertEquals(GeomOutputFormat.EWKB, GeomOutputFormat.valueOf("EWKB"))
        assertEquals(GeomOutputFormat.WKT, GeomOutputFormat.valueOf("WKT"))
        assertEquals(GeomOutputFormat.EWKT, GeomOutputFormat.valueOf("EWKT"))
    }

    fun testEnumOrdinal() {
        assertEquals(0, GeomOutputFormat.WKB.ordinal)
        assertEquals(1, GeomOutputFormat.EWKB.ordinal)
        assertEquals(2, GeomOutputFormat.WKT.ordinal)
        assertEquals(3, GeomOutputFormat.EWKT.ordinal)
    }
}
