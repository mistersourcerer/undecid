import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import ui.welcome

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            welcome { name = "Kotlin/JS" }
        }
    }
}
