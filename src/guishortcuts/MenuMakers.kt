package guishortcuts

import javax.swing.*

val bar = 0
val separator = 1
val menu = 2
val check = 3
val radio = 0.0
val group = 1.0

infix fun Int.menu(kw: Int): JMenuBar {
    if(this != create) throw Exception("Use 'create menu bar' to create a menu bar")
    if(kw != bar) throw Exception("Use 'create menu bar' to create a menu bar")
    return JMenuBar()
}

infix fun Int.menu(text: String): JMenu {
    if(this != create) throw Exception("Use 'create' to create a menu")
    return JMenu(text)
}

infix fun Int.menuitem(text: String): JMenuItem {
    if(this != create) throw Exception("Use 'create' to create a menu item")
    return JMenuItem(text)
}

infix fun Int.checkbox(other: Int): Int {
    return check
}

infix fun Int.radiobutton(other: Int): Double {
    return radio
}

infix fun Int.item(text: String): JCheckBoxMenuItem {
    if(this != check) throw Exception("Use 'check' to create checkbox menu items")
    return JCheckBoxMenuItem(text)
}

infix fun Double.item(text: String): JRadioButtonMenuItem {
    if(this != radio) throw Exception("Use 'radio' to create radio button menu items")
    return JRadioButtonMenuItem(text)
}

infix fun Double.item(value: Double): ButtonGroup {
    if(this != radio) throw Exception("Use 'radio' to create radio button groups")
    if(value != group) throw Exception("Use 'group' to create radio button groups")
    return ButtonGroup()
}

infix fun Int.radiobutton(other: Double): ButtonGroup {
    if(this != create) throw Exception("Use 'create' to create radio button groups")
    if(other != group) throw Exception("Use 'group' to create radio button groups")
    return ButtonGroup()
}

infix fun JRadioButtonMenuItem.to(group: ButtonGroup) {
    group.add(this)
}

infix fun Int.check(other: Int): Int {
    return other
}

infix fun Int.radio(other: Int): Int {
    return other
}

infix fun Int.add(menuitem: JMenuItem): JMenuItem {
    if(this != window) throw Exception("Use 'window' when adding a menu item to a menu")
    return menuitem
}

infix fun Int.add(menuitem: JRadioButtonMenuItem): JRadioButtonMenuItem {
    if(this != window) throw Exception("Use 'window' when adding a radio button menu item to a menu")
    return menuitem
}

infix fun JMenuItem.to(menu: JMenu) {
    menu.add(this)
}

infix fun Int.add(menu: JMenu): JMenu {
    if(this != window) throw Exception("Use 'window' when adding a menu to a menu bar")
    return menu
}

infix fun JMenu.to(menuBar: JMenuBar) {
    menuBar.add(this)
}

infix fun Int.add(menuBar: JMenuBar): JMenuBar {
    if(this != window) throw Exception("Use 'window' when adding a menu bar to a frame")
    return menuBar
}

infix fun JMenuBar.to(frame: JFrame) {
    frame.jMenuBar = this
}

infix fun Int.add(other: Int): Int {
    if(this != window) throw Exception("Use 'window' when adding a separator to a menu")
    if(other != separator) throw Exception("Use 'separator' when adding a separator to a menu")
    return other
}

infix fun Int.to(menu: JMenu) {
    if(this != separator) throw Exception("Use 'separator' when adding a separator to a menu")
    menu.addSeparator()
}

infix fun JMenuItem.mnemonic(key: Char) {
    setMnemonic(key)
}

infix fun JMenuItem.alt(key: Char) {
    accelerator = KeyStroke.getKeyStroke("alt $key")
}

infix fun JMenuItem.ctrl(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control $key")
}

infix fun JMenuItem.shift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("shift $key")
}

infix fun JMenuItem.Fn(key: Int) {
    accelerator = KeyStroke.getKeyStroke("F$key")
}

infix fun JMenuItem.ctrlalt(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control alt $key")
}

infix fun JMenuItem.ctrlshift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control shift $key")
}

infix fun JMenuItem.altshift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("alt shift $key")
}

infix fun JMenuItem.ctrlaltshift(key: Char) {
    accelerator = KeyStroke.getKeyStroke("control alt shift $key")
}

infix fun JMenuItem.does(func: () -> Unit) {
    addActionListener {func()}
}

infix fun Int.selected(menuitem: JMenuItem) {
    if(this != make) throw Exception("Use 'make' to toggle whether a radio button menu item is selected")
    menuitem.isSelected = true
}

infix fun Int.deselected(menuitem: JMenuItem) {
    if(this != make) throw Exception("Use 'make' to toggle whether a radio button menu item is selected")
    menuitem.isSelected = false
}
