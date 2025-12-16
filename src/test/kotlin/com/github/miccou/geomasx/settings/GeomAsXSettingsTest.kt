package com.github.miccou.geomasx.settings

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class GeomAsXSettingsTest : BasePlatformTestCase() {

    private lateinit var settings: GeomAsXSettings

    override fun setUp() {
        super.setUp()
        settings = GeomAsXSettings()
    }

    fun testDefaultValues() {
        assertEquals(true, settings.enabled)
        assertEquals(GeomOutputFormat.WKB, settings.geomOutputFormat)
    }

    fun testSetEnabled() {
        settings.enabled = false
        assertFalse(settings.enabled)

        settings.enabled = true
        assertTrue(settings.enabled)
    }

    fun testSetGeomOutputFormat() {
        GeomOutputFormat.entries.forEach { format ->
            settings.geomOutputFormat = format
            assertEquals(format, settings.geomOutputFormat)
        }
    }

    fun testGetState() {
        settings.enabled = false
        settings.geomOutputFormat = GeomOutputFormat.EWKT

        val state = settings.state
        assertEquals(false, state.enabled)
        assertEquals(GeomOutputFormat.EWKT, state.geomOutputFormat)
    }

    fun testLoadState() {
        val newState = GeomAsXSettings.State(
            enabled = false,
            geomOutputFormat = GeomOutputFormat.WKT
        )

        settings.loadState(newState)

        assertEquals(false, settings.enabled)
        assertEquals(GeomOutputFormat.WKT, settings.geomOutputFormat)
    }

    fun testStateDataClassDefaults() {
        val state = GeomAsXSettings.State()
        assertEquals(true, state.enabled)
        assertEquals(GeomOutputFormat.WKB, state.geomOutputFormat)
    }

    fun testStateDataClassCopy() {
        val originalState = GeomAsXSettings.State(enabled = true, geomOutputFormat = GeomOutputFormat.WKB)
        val modifiedState = originalState.copy(enabled = false, geomOutputFormat = GeomOutputFormat.EWKB)

        assertEquals(true, originalState.enabled)
        assertEquals(GeomOutputFormat.WKB, originalState.geomOutputFormat)

        assertEquals(false, modifiedState.enabled)
        assertEquals(GeomOutputFormat.EWKB, modifiedState.geomOutputFormat)
    }
}
