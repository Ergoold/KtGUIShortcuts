package guishortcuts

import guishortcuts.consrainables.*
import java.awt.*
import javax.swing.*

val create = 0
val make = 1
val window = 2
val full = 3
val message = 4
val confirm = 5
val input = 6

infix fun Int.frame(title: String): JFrame {
    if(this != create) throw Exception("Use 'create' when attempting to create a frame")
    return JFrame(title)
}

infix fun Int.init(frame: JFrame) {
    if(this != window) throw Exception("Use 'window' when attempting to initialize a frame")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.layout = GridBagLayout()
    frame.pack()
    frame.isVisible = true
}

infix fun Int.pack(frame: JFrame) {
    if(this != window) throw Exception("Use 'window' when attempting to pack a frame")
    frame.pack()
}

infix fun JFrame.set(dim: Dimension) {
    this.size = dim
}

fun size(x: Int, y: Int): Dimension {
    return Dimension(x, y)
}

infix fun Int.visible(frame: JFrame) {
    if(this != make) throw Exception("Use 'make' when attempting to set frame visibility")
    frame.isVisible = true
}

infix fun Int.invisible(frame: JFrame) {
    if(this != make) throw Exception("Use 'make' when attempting to set frame visibility")
    frame.dispose()
}

infix fun Int.screen(frame: JFrame) {
    if(this != full) throw Exception("Unknown command: did you mean full screen <frame>")
    frame.extendedState = JFrame.MAXIMIZED_BOTH
}

infix fun Int.label(text: String): ConstrainedLabel {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedLabel(text)
}

infix fun Int.button(text: String): ConstrainedButton {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedButton(text)
}

infix fun Int.checkbox(text: String): ConstrainedCheckbox {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedCheckbox(text)
}

infix fun Int.combobox(text: Array<String>): ConstrainedCombobox {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedCombobox(text)
}

infix fun Int.radiobutton(text: String): ConstrainedRadioButton {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedRadioButton(text)
}

infix fun Int.list(text: Array<String>): ConstrainedList {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedList(text)
}

fun slider(min: Int, max: Int): ConstrainedSlider {
    return ConstrainedSlider(min, max)
}

fun options(vararg options: String): Array<String> {
    return options as Array<String>
}

infix fun Int.dialog(text: String) {
    when(this) {
        message -> JOptionPane.showMessageDialog(null, text)
        confirm -> JOptionPane.showConfirmDialog(null, text)
        input -> JOptionPane.showInputDialog(null, text)
        else -> throw Exception("You must specify a dialog type")
    }
}

infix fun Array<String>.dialog(text: String) {
    JOptionPane.showOptionDialog(null, text, "", -1, -1, null, this, this[0])
}
