package guishortcuts

import java.awt.*
import javax.swing.*

/**
 * Create a new frame.
 * Int must be equal to the variable create.
 *
 * @param title the new frame's title.
 *
 * @return a frame with the supplied title.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.frame(title: String): JFrame {
    if(this != create) throw IllegalKeywordException("Use 'create' when attempting to create a frame")
    return JFrame(title)
}

/**
 * Initialize values for frame.
 * Int must be equal to the variable window.
 *
 * @param frame the frame to initialize values.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.init(frame: JFrame) {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to initialize a frame")
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
 *
 * @throws IllegalKeywordException
 */
infix fun Int.pack(frame: JFrame) {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to pack a frame")
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
 *
 * @throws IllegalKeywordException
 */
infix fun Int.visible(frame: JFrame) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set frame visibility")
    frame.isVisible = true
}

/**
 * Make a frame invisible.
 * Int must be equal to the variable make.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.invisible(frame: JFrame) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set frame visibility")
    frame.dispose()
}

/**
 * Maximize a frame to full screen.
 * Int must be equal to the variable full.
 *
 * @param frame to maximize to full screen.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.screen(frame: JFrame) {
    if(this != full) throw IllegalKeywordException("Unknown command: did you mean full screen <frame>")
    frame.extendedState = JFrame.MAXIMIZED_BOTH
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
 *
 * @throws IllegalArgumentException
 */
infix fun Int.dialog(text: String) {
    when(this) {
        message -> JOptionPane.showMessageDialog(null, text)
        confirm -> JOptionPane.showConfirmDialog(null, text)
        input -> JOptionPane.showInputDialog(null, text)
        else -> throw IllegalArgumentException("You must specify a dialog type")
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
