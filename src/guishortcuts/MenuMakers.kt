package guishortcuts

import javax.swing.*

/**
 * Create a menu bar.
 * Int must be equal to the variable create.
 *
 * @param kw must be equal to the variable bar.
 *
 * @return a JMenuBar.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.menu(kw: Int): JMenuBar {
    if(this != create) throw IllegalKeywordException("Use 'create menu bar' to create a menu bar")
    if(kw != bar) throw IllegalKeywordException("Use 'create menu bar' to create a menu bar")
    return JMenuBar()
}

/**
 * Create a menu.
 * Int must be equal to the variable create.
 *
 * @param text the text on this menu.
 *
 * @return a menu with the supplied text.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.menu(text: String): JMenu {
    if(this != create) throw IllegalKeywordException("Use 'create' to create a menu")
    return JMenu(text)
}

/**
 * Create a menu item.
 * Int must be equal to the variable create.
 *
 * @param text the text on this menu item.
 *
 * @return a menu item with the supplied text.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.menuitem(text: String): JMenuItem {
    if(this != create) throw IllegalKeywordException("Use 'create' to create a menu item")
    return JMenuItem(text)
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param other should be equal to the variable menu.
 *
 * @return the variable check.
 */
infix fun Int.checkbox(other: Int): Int {
    return check
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param other should be equal to the variable menu.
 *
 * @return the variable radio.
 */
infix fun Int.radiobutton(other: Int): Double {
    return radio
}

/**
 * Create a checkbox menu item.
 * Int must be equal to the variable check.
 *
 * @param text the text on the checkbox menu item.
 *
 * @return a checkbox menu item with the supplied text.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.item(text: String): JCheckBoxMenuItem {
    if(this != check) throw IllegalKeywordException("Use 'check' to create checkbox menu items")
    return JCheckBoxMenuItem(text)
}

/**
 * Create a radio button menu item.
 * Int must be equal to the variable radio.
 *
 * @param text the text on the radio button menu item.
 *
 * @return a radio button menu item with the supplied text.
 *
 * @throws IllegalKeywordException
 */
infix fun Double.item(text: String): JRadioButtonMenuItem {
    if(this != radio) throw IllegalKeywordException("Use 'radio' to create radio button menu items")
    return JRadioButtonMenuItem(text)
}

/**
 * Create a radio button group.
 * Double must be equal to the variable radio.
 *
 * @param value must be equal to the variable group.
 *
 * @return a radio button group.
 *
 * @throws IllegalKeywordException
 */
infix fun Double.item(value: Double): ButtonGroup {
    if(this != radio) throw IllegalKeywordException("Use 'radio' to create radio button groups")
    if(value != group) throw IllegalKeywordException("Use 'group' to create radio button groups")
    return ButtonGroup()
}

/**
 * Create a radio button group.
 * Int must be equal to the variable create.
 *
 * @param other must be equal to the variable group.
 *
 * @return a radio button group.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.radiobutton(other: Double): ButtonGroup {
    if(this != create) throw IllegalKeywordException("Use 'create' to create radio button groups")
    if(other != group) throw IllegalKeywordException("Use 'group' to create radio button groups")
    return ButtonGroup()
}

/**
 * Add a radio button menu item to a radio button group.
 *
 * @param group the radio button group this radio button will be added to.
 */
infix fun JRadioButtonMenuItem.to(group: ButtonGroup) {
    group.add(this)
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param other the Int to return.
 *
 * @return the Int it was given.
 */
infix fun Int.check(other: Int): Int {
    return other
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param other the Int to return.
 *
 * @return the Int it was given.
 */
infix fun Int.radio(other: Int): Int {
    return other
}

/**
 * This function is purely for cosmetic purposes.
 * Int must be equal to the variable window.
 *
 * @param menuitem the menu item to return.
 *
 * @return the menu item it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(menuitem: JMenuItem): JMenuItem {
    if(this != window) throw IllegalKeywordException("Use 'window' when adding a menu item to a menu")
    return menuitem
}

/**
 * This function is purely for cosmetic purposes.
 * Int must be equal to the variable window.
 *
 * @param menuitem the radio button menu item to return.
 *
 * @return the radio button menu item it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(menuitem: JRadioButtonMenuItem): JRadioButtonMenuItem {
    if(this != window) throw IllegalKeywordException("Use 'window' when adding a radio button menu item to a menu")
    return menuitem
}

/**
 * Add this menu item to a menu.
 *
 * @param menu the menu this menu item will be added to.
 */
infix fun JMenuItem.to(menu: JMenu) {
    menu.add(this)
}

/**
 * This function is purely for cosmetic purposes.
 * Int must be equal to the variable window.
 *
 * @param menu the menu to return.
 *
 * @return the menu it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(menu: JMenu): JMenu {
    if(this != window) throw IllegalKeywordException("Use 'window' when adding a menu to a menu bar")
    return menu
}

/**
 * Add this menu to a menu bar.
 *
 * @param menuBar the menu bar this menu will be added to.
 */
infix fun JMenu.to(menuBar: JMenuBar) {
    menuBar.add(this)
}

/**
 * This function is purely for cosmetic purposes.
 * Int must be equal to the variable window.
 *
 * @param menuBar the menu bar to return.
 *
 * @return the menu bar it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(menuBar: JMenuBar): JMenuBar {
    if(this != window) throw IllegalKeywordException("Use 'window' when adding a menu bar to a frame")
    return menuBar
}

/**
 * Add this menu bar to a frame.
 *
 * @param frame the frame this menu bar will be added to.
 */
infix fun JMenuBar.to(frame: JFrame) {
    frame.jMenuBar = this
}

/**
 * This function is purely for cosmetic purposes.
 * Int must be equal to the variable window.
 *
 * @param other must be equal to separator.
 *
 * @return the other it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(other: Int): Int {
    if(this != window) throw IllegalKeywordException("Use 'window' when adding a separator to a menu")
    if(other != separator) throw IllegalKeywordException("Use 'separator' when adding a separator to a menu")
    return other
}

/**
 * Add a separator to a menu.
 *
 * @param menu the menu a separator will be added to.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.to(menu: JMenu) {
    if(this != separator) throw IllegalKeywordException("Use 'separator' when adding a separator to a menu")
    menu.addSeparator()
}

/**
 * Set this menu item's mnemonic to a key.
 *
 * @param key the key to set this menu item's mnemonic to.
 */
infix fun JMenuItem.mnemonic(key: Char) {
    setMnemonic(key)
}

/**
 * Set a menu item's shortcut to an alt key combination.
 *
 * @param key the shortcut will be alt+key.
 */
infix fun JMenuItem.alt(key: Char) {
    accelerator = KeyStroke.getKeyStroke("alt $key")
}

/**
 * Set a menu item's shortcut to a ctrl key combination.
 *
 * @param key the shortcut will be ctrl+key.
 */
infix fun JMenuItem.ctrl(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control $key")
}

/**
 * Set a menu item's shortcut to a shift key combination.
 *
 * @param key the shortcut will be shift+key.
 */
infix fun JMenuItem.shift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("shift $key")
}

/**
 * Set a menu item's shortcut to a function key.
 *
 * @param key the shortcut will be Fkey.
 */
infix fun JMenuItem.Fn(key: Int) {
    accelerator = KeyStroke.getKeyStroke("F$key")
}

/**
 * Set a menu item's shortcut to a ctrl & alt key combination.
 *
 * @param key the shortcut will be ctrl+alt+key.
 */
infix fun JMenuItem.ctrlalt(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control alt $key")
}

/**
 * Set a menu item's shortcut to a ctrl & shift key combination.
 *
 * @param key the shortcut will be ctrl+shift+key.
 */
infix fun JMenuItem.ctrlshift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control shift $key")
}

/**
 * Set a menu item's shortcut to an alt & shift key combination.
 *
 * @param key the shortcut will be alt+shift+key.
 */
infix fun JMenuItem.altshift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("alt shift $key")
}

/**
 * Set a menu item's shortcut to a ctrl & alt & shift key combination.
 *
 * @param key the shortcut will be ctrl+alt+shift+key.
 */
infix fun JMenuItem.ctrlaltshift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control alt shift $key")
}

/**
 * Add an action listener to this menu item.
 *
 * @param func the function to be executed when this menu item is pressed.
 */
infix fun JMenuItem.does(func: () -> Unit) {
    addActionListener {func()}
}

/**
 * Make a radio button menu item selected.
 * Int must be equal to the variable make.
 *
 * @param menuitem the radio button menu item to make selected.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.selected(menuitem: JMenuItem) {
    if(this != make) throw IllegalKeywordException("Use 'make' to toggle whether a radio button menu item is selected")
    menuitem.isSelected = true
}

/**
 * Make a radio button menu item deselected.
 * Int must be equal to the variable make.
 *
 * @param menuitem the radio button menu item to make deselected.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.deselected(menuitem: JMenuItem) {
    if(this != make) throw IllegalKeywordException("Use 'make' to toggle whether a radio button menu item is selected")
    menuitem.isSelected = false
}
