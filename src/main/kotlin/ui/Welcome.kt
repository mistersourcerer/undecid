package ui

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*

external interface WelcomeProps : RProps {
    var name: String
}

//fun RBuilder.ui.welcome(name: String) = child(ui.welcome) {
//    attrs.name = name
//}
// or:
fun RBuilder.welcome(handler: WelcomeProps.() -> Unit) = child(welcome) {
    attrs {
        handler()
    }
}
// so we can: ui.welcome { name = "Kotlin" }

//@JsExport
private val welcome = functionalComponent<WelcomeProps> { props ->
    //var (name, setName) = useState(props.name)
    // or
    var name by useState(props.name)
    h2 {
        +"Hello, $name"
    }

    input {
        attrs {
            type = InputType.text
            value = name
            onChangeFunction = { event ->
                name = (event.target as HTMLInputElement).value
            }
        }
    }
}
