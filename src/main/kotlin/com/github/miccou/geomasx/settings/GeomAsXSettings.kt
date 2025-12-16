package com.github.miccou.geomasx.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

enum class GeomOutputFormat{WKB, EWKB, WKT, EWKT}

@Service(Service.Level.APP)
@State(
    name = "com.github.miccou.geomasx.settings.GeomAsXSettings",
    storages = [Storage("GeomAsXSettings.xml")]
)

class GeomAsXSettings : PersistentStateComponent<GeomAsXSettings.State> {



    data class State(
        var enabled: Boolean = true,
        var geomOutputFormat: GeomOutputFormat = GeomOutputFormat.WKB
    )

    private var state = State()

    override fun getState(): State = state

    override fun loadState(state: State) {
        this.state = state
    }

    var enabled: Boolean
        get() = state.enabled
        set(value) {
            state.enabled = value
        }

    var geomOutputFormat: GeomOutputFormat
        get() = state.geomOutputFormat
        set(value) {
            state.geomOutputFormat = value
        }

    companion object {
        val instance: GeomAsXSettings
            get() = ApplicationManager.getApplication().getService(GeomAsXSettings::class.java)
    }
}


