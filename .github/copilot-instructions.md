# Copilot Instructions for GeomAsX

## Project Overview

This is an IntelliJ Platform Plugin targeting **PyCharm only**. The plugin is built using Gradle and the IntelliJ Platform Gradle Plugin.

## Language & Framework

- **Primary Language**: Kotlin (use Kotlin for all new code)
- **Build System**: Gradle with Kotlin DSL (`build.gradle.kts`)
- **Platform**: IntelliJ Platform SDK
- **Target IDE**: PyCharm (Community and Professional)

## Coding Conventions

### Kotlin Style

- Use Kotlin idioms (data classes, extension functions, null safety)
- Prefer `val` over `var` where possible
- Use meaningful names following Kotlin naming conventions (camelCase for functions/properties, PascalCase for classes)
- Keep functions small and focused
- Use Kotlin coroutines for async operations when needed

### IntelliJ Platform Guidelines

- Follow IntelliJ Platform SDK conventions
- Register extensions in `plugin.xml`
- Use `com.intellij.openapi` APIs appropriately
- Implement `Configurable` interface for settings panels
- Use `PersistentStateComponent` for persisting settings

## Plugin Configuration

### Target Platform

Configure `gradle.properties` and `build.gradle.kts` to target PyCharm:

```kotlin
intellij {
    type.set("PY") // PyCharm Community
    // or "PC" for PyCharm Professional only
}
```

### Settings Panel

When implementing settings:

1. Create a `Configurable` implementation for the settings UI
2. Create a `PersistentStateComponent` for state persistence
3. Register in `plugin.xml` under `<extensions defaultExtensionNs="com.intellij">`
4. Use `com.intellij.openapi.options.Configurable` for simple settings
5. Place settings classes in a `settings` package

Example structure:

```
src/main/kotlin/
  └── com/yourpackage/
      ├── settings/
      │   ├── GeomAsXSettings.kt        // State/persistence
      │   └── GeomAsXConfigurable.kt    // UI panel
      └── ...
```

## File Organization

- Source code: `src/main/kotlin/`
- Resources: `src/main/resources/`
- Plugin descriptor: `src/main/resources/META-INF/plugin.xml`
- Tests: `src/test/kotlin/`

## Testing

- Write unit tests for business logic
- Use IntelliJ test framework for integration tests
- Place tests in `src/test/kotlin/` mirroring main structure
