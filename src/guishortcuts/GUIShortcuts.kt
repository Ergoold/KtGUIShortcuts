package guishortcuts

import guishortcuts.consrainables.*
import java.awt.*
import javax.swing.*

/**
 * Create a new frame.
 * Int must be equal to the variable create.
 *
 * @param title the new frame's title.
 *
 * @return a frame with the supplied title.
 */
infix fun Int.frame(title: String): JFrame {
    if(this != create) throw Exception("Use 'create' when attempting to create a frame")
    return JFrame(title)
}

/**
 * Initialize values for frame.
 * Int must be equal to the variable window.
 *
 * @param frame the frame to initialize values.
 */
infix fun Int.init(frame: JFrame) {
    if(this != window) throw Exception("Use 'window' when attempting to initialize a frame")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.layout = GridBagLayout()
    frame.pack()
    frame.isVisible = true
}

/**
 * Pack a frame.
 * Int must be equal to the variable window.
 *
 * @param frame the frame to pack.
 */
infix fun Int.pack(frame: JFrame) {
    if(this != window) throw Exception("Use 'window' when attempting to pack a frame")
    frame.pack()
}

/**
 * Set the dimensions of a frame.
 *
 * @param dim the dimensions to set the frame to.
 */
infix fun JFrame.set(dim: Dimension) {
    this.size = dim
}

/**
 * Turn two Ints into a Dimension object.
 *
 * @param x the x dimension.
 * @param y the y dimension.
 *
 * @return a Dimension object with the values supplied.
 */
fun size(x: Int, y: Int): Dimension {
    return Dimension(x, y)
}

/**
 * Make a frame visible.
 * Int must be equal to the variable make.
 *
 * @param frame the frame to make visible.
 */
infix fun Int.visible(frame: JFrame) {
    if(this != make) throw Exception("Use 'make' when attempting to set frame visibility")
    frame.isVisible = true
}

/**
 * Make a frame invisible.
 * Int must be equal to the variable make.
 */
infix fun Int.invisible(frame: JFrame) {
    if(this != make) throw Exception("Use 'make' when attempting to set frame visibility")
    frame.dispose()
}

/**
 * Maximize a frame to full screen.
 * Int must be equal to the variable full.
 *
 * @param frame to maximize to full screen.
 */
infix fun Int.screen(frame: JFrame) {
    if(this != full) throw Exception("Unknown command: did you mean full screen <frame>")
    frame.extendedState = JFrame.MAXIMIZED_BOTH
}

/**
 * Create a label.
 * Int must be equal to the variable create.
 *
 * @param text the text on the created label.
 *
 * @return a ConstrainedLabel with the supplied text.
 */
infix fun Int.label(text: String): ConstrainedLabel {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedLabel(text)
}

/**
 * Create a button.
 * Int must be equal to the variable create.
 *
 * @param text the text on the created button.
 *
 * @return a ConstrainedButton with the supplied text.
 */
infix fun Int.button(text: String): ConstrainedButton {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedButton(text)
}

/**
 * Create a checkbox.
 * Int must be equal to the variable create.
 *
 * @param text the text on the created checkbox.
 *
 * @return a ConstrainedCheckbox with the supplied text.
 */
infix fun Int.checkbox(text: String): ConstrainedCheckbox {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedCheckbox(text)
}

/**
 * Create a combobox.
 * Int must be equal to the variable create.
 *
 * @param text an array of the values in the combobox.
 *
 * @return a ConstrainedCombobox with the supplied text values.
 */
infix fun Int.combobox(text: Array<String>): ConstrainedCombobox {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedCombobox(text)
}

/**
 * Create a radio button.
 * Int must be equal to the variable create.
 *
 * @param text the text on the created radio button.
 *
 * @return a ConstrainedRadioButton with the supplied text.
 */
infix fun Int.radiobutton(text: String): ConstrainedRadioButton {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedRadioButton(text)
}

/**
 * Create a list.
 * Int must be equal to the variable create.
 *
 * @param text an array of the values in the list.
 *
 * @return a ConstrainedList with the supplied text values.
 */
infix fun Int.list(text: Array<String>): ConstrainedList {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedList(text)
}

/**
 * Create a spinner.
 * Int must be equal to the variable create.
 *
 * @param text an array of the values in the spinner.
 *
 * @return a ConstrainedSpinner with the supplied text values.
 */
infix fun Int.spinner(text: Array<String>): ConstrainedSpinner {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedSpinner(text)
}

/**
 * Create a spinner.
 * Int must be equal to the variable create.
 *
 * @param min the minimum value of the spinner.
 * @param max the maximum value of the spinner.
 *
 * @return a ConstrainedSlider with the supplied minimum and maximum.
 */
fun slider(min: Int, max: Int): ConstrainedSlider {
    val slider = ConstrainedSlider(min, max)
    slider.majorTickSpacing = max - min
    slider.minorTickSpacing = (max - min) / 2
    slider.paintTicks = true
    slider.paintLabels = true
    return slider
}

/**
 * Create a text field.
 * Int must be equal to the variable create.
 *
 * @param content the initial content of the text field.
 *
 * @return a ConstrainedTextField with the supplied content.
 */
infix fun Int.textfield(content: String): ConstrainedTextField {
    if(this != create) throw Exception("Use 'create' when creating components")
    val textfield = ConstrainedTextField(content)
    return textfield
}

/**
 * Turn a vararg of Strings into an Array<String>.
 *
 * @param options a vararg of the Strings to put in the array.
 */
fun options(vararg options: String): Array<String> {
    return options as Array<String>
}

/**
 * Show a dialog to the user.
 * Int must be equal to one of the following variables:
 * message: show a message dialog with an OK button.
 * confirm: show a confirmation dialog with an OK option and a Cancel option.
 * input: show a textual input dialog with a textbox and an OK button.
 *
 * @param text the text to be shown within the dialog.
 */
infix fun Int.dialog(text: String) {
    when(this) {
        message -> JOptionPane.showMessageDialog(null, text)
        confirm -> JOptionPane.showConfirmDialog(null, text)
        input -> JOptionPane.showInputDialog(null, text)
        else -> throw Exception("You must specify a dialog type")
    }
}

/**
 * Show a dialog with a combobox to the user.
 * Array is the array of options inside of the combobox.
 *
 * @param text the text to be shown within the dialog.
 */
infix fun Array<String>.dialog(text: String) {
    JOptionPane.showOptionDialog(null, text, "", -1, -1, null, this, this[0])
}
