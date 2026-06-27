# Proyecto de Automatización Demoblaze

Este proyecto realiza la automatización del flujo de compra en el sitio web [Demoblaze](https://www.demoblaze.com/) utilizando el framework **Serenity BDD** con el patrón de diseño **Screenplay**.

## 🚀 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

*   **Java JDK 17** o superior.
*   **Gradle** (opcional, se incluye `gradlew`).
*   **Google Chrome** (el driver se gestiona automáticamente con WebDriverManager).
*   Un IDE como **IntelliJ IDEA** o **Android Studio**.

## 🛠️ Configuración del Proyecto

1.  **Clonar el repositorio:**
    ```bash
    git clone <url-del-repositorio>
    cd demoblaze_automation
    ```

2.  **Configuración de entorno:**
    Los parámetros base se encuentran en `src/test/resources/serenity.conf` y `serenity.properties`.
    La URL base está configurada como: `https://www.demoblaze.com/`

## 🏃 Ejecución de Pruebas

### Desde la Línea de Comandos
Para ejecutar todos los tests y generar el reporte automáticamente:
```bash
./gradlew test aggregate
```
*El reporte se abrirá automáticamente en tu navegador predeterminado al finalizar gracias a la tarea `openSerenityReport` configurada en `build.gradle`.*

### Desde el IDE (IntelliJ / Android Studio)
1.  Navega a `src/test/java/com/demoblaze/runners/DemoblazeRunner.java`.
2.  Haz clic derecho en la clase y selecciona **Run 'DemoblazeRunner'**.

## 📊 Reportes de Ejecución
Serenity genera reportes detallados en HTML.
*   **Ruta del reporte:** `target/site/serenity/index.html`
*   **Capturas de pantalla:** El proyecto está configurado para tomar capturas de pantalla de cada acción (`FOR_EACH_ACTION`), permitiendo una auditoría visual completa.

## 🏗️ Arquitectura del Proyecto (Screenplay)
El proyecto sigue la estructura estándar de Screenplay para mayor legibilidad y mantenibilidad:

*   **Tasks:** Clases que representan acciones de alto nivel (ej: `AddProductDemoblazeToCarTask`).
*   **UI:** Mapeo de elementos web (Targets) (ej: `DemoblazeHomePage`).
*   **Questions:** Verificaciones y validaciones del estado de la aplicación (ej: `ValidateTotalPriceQuestion`).
*   **StepDefinitions:** Conexión entre los pasos de Gherkin y el código Java.
*   **Features:** Escenarios de prueba escritos en lenguaje Gherkin.

## 📝 Notas Adicionales
*   **Logs:** Se han implementado logs detallados en las Questions para facilitar el debugging desde la consola.
*   **Alertas:** El proyecto maneja automáticamente las alertas de JavaScript nativas del navegador al agregar productos.

---
**Desarrollado por:** John Eliseo Robles Alba
