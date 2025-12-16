package com.github.miccou.geomasx.settings

import com.intellij.openapi.options.Configurable
import com.intellij.ui.dsl.builder.*
import javax.swing.JComponent

class GeomAsXConfigurable : Configurable {

    private var enabledCheckbox: Boolean = true
    private var selectedGeomOutputFormat: GeomOutputFormat = GeomOutputFormat.WKB

    override fun getDisplayName(): String = "GeomAsX"

    override fun createComponent(): JComponent {
        val settings = GeomAsXSettings.instance
        enabledCheckbox = settings.enabled
        selectedGeomOutputFormat = settings.geomOutputFormat

        return panel {
            lateinit var enabledProperty: Cell<javax.swing.JCheckBox>

            group("General Settings") {
                row {
                    enabledProperty = checkBox("Enable GeomAsX")
                        .bindSelected(::enabledCheckbox)
                }
            }

            group("Geometry Column Output Format") {
                buttonsGroup {
                    GeomOutputFormat.entries.forEach { outputFormat ->
                        row {
                            radioButton(outputFormat.toString(), outputFormat)
                        }
                    }
                }.bind(::selectedGeomOutputFormat)
            }.enabledIf(enabledProperty.selected)

        }
    }

    override fun isModified(): Boolean {
        val settings = GeomAsXSettings.instance
        return enabledCheckbox != settings.enabled ||
                selectedGeomOutputFormat != settings.geomOutputFormat
    }

    override fun apply() {
        val settings = GeomAsXSettings.instance
        settings.enabled = enabledCheckbox
        selectedGeomOutputFormat = settings.geomOutputFormat
    }

    override fun reset() {
        val settings = GeomAsXSettings.instance
        enabledCheckbox = settings.enabled
        selectedGeomOutputFormat = settings.geomOutputFormat
    }
}