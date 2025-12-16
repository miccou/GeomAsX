package com.github.miccou.geomasx.settings

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class GeomAsXConfigurableTest : BasePlatformTestCase() {

    private lateinit var configurable: GeomAsXConfigurable
    private lateinit var settings: GeomAsXSettings

    override fun setUp() {
        super.setUp()
        settings = GeomAsXSettings.instance
        // Reset settings to defaults before each test
        settings.enabled = true
        settings.geomOutputFormat = GeomOutputFormat.WKB
        configurable = GeomAsXConfigurable()
    }

    override fun tearDown() {
        try {
            configurable.disposeUIResources()
        } finally {
            super.tearDown()
        }
    }

    fun testDisplayName() {
        assertEquals("GeomAsX", configurable.displayName)
    }

    fun testCreateComponentNotNull() {
        val component = configurable.createComponent()
        assertNotNull(component)
    }

    fun testIsModifiedWhenUnchanged() {
        configurable.createComponent()
        assertFalse(configurable.isModified)
    }

    fun testResetRestoresSettings() {
        // Change settings
        settings.enabled = false
        settings.geomOutputFormat = GeomOutputFormat.EWKT

        // Create component (which should load current settings)
        configurable.createComponent()

        // Reset should restore to current settings state
        configurable.reset()

        // isModified should be false after reset
        assertFalse(configurable.isModified)
    }
}
