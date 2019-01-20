package guishortcuts

fun main(args: Array<String>) {
    val frame = create frame "test"
    window init frame

    val menuBar = create menu bar

    val fileMenu = create menu "File"
    val editMenu = create menu "Edit"
    val helpMenu = create menu "Help"

    val newFile = create menuitem "New"
    val openFile = create menuitem "Open"
    val saveFile = create menuitem "Save"
    val saveAsFile = create menuitem "Save As"
    val settingsFile = create menu "Settings"
    val darkSettings = create checkbox menu item "Dark Theme"
    val groupOneTwo = create radiobutton menu item group
    val oneSettings = create radiobutton menu item "Uno"
    val twoSettings = create radiobutton menu item "Dos"

    val copyEdit = create menuitem "Copy"
    val cutEdit = create menuitem "Cut"
    val pasteEdit = create menuitem "Paste"

    val helpHelp = create menuitem "Help"
    val keysHelp = create menuitem "Keys"
    val aboutHelp = create menuitem "About"

    window add newFile to fileMenu
    newFile mnemonic 'N'
    newFile ctrl 'N'
    newFile does {
        message dialog "You clicked New"
    }
    window add openFile to fileMenu
    openFile mnemonic 'O'
    openFile ctrl 'O'
    openFile does {
        message dialog "You clicked Open"
    }
    window add separator to fileMenu
    window add saveFile to fileMenu
    saveFile mnemonic 'S'
    saveFile ctrl 'S'
    saveFile does {
        message dialog "You clicked Save"
    }
    window add saveAsFile to fileMenu
    saveAsFile mnemonic 'A'
    saveAsFile ctrlshift 'S'
    saveAsFile does {
        message dialog "You clicked Save As"
    }
    window add separator to fileMenu
    window add settingsFile to fileMenu
    settingsFile mnemonic 'E'
    settingsFile does {
        message dialog "You clicked Settings"
    }
    window add darkSettings to settingsFile
    darkSettings mnemonic 'D'
    darkSettings ctrlalt 'D'
    window add separator to settingsFile
    window add oneSettings to groupOneTwo
    window add oneSettings to settingsFile
    make selected oneSettings
    oneSettings mnemonic 'U'
    oneSettings ctrlalt '1'
    window add twoSettings to groupOneTwo
    window add twoSettings to settingsFile
    twoSettings mnemonic 'O'
    twoSettings ctrlalt '2'

    window add copyEdit to editMenu
    copyEdit mnemonic 'C'
    copyEdit ctrl 'C'
    copyEdit does {
        message dialog "You clicked Copy"
    }
    window add cutEdit to editMenu
    cutEdit mnemonic 'T'
    cutEdit ctrl 'X'
    cutEdit does {
        message dialog "You clicked Cut"
    }
    window add separator to editMenu
    window add pasteEdit to editMenu
    pasteEdit mnemonic 'P'
    pasteEdit ctrl 'V'
    pasteEdit does {
        message dialog "You clicked Paste"
    }

    window add helpHelp to helpMenu
    helpHelp mnemonic 'H'
    helpHelp Fn 1
    helpHelp does {
        message dialog "You clicked Help"
    }
    window add keysHelp to helpMenu
    keysHelp mnemonic 'K'
    keysHelp ctrl 'K'
    keysHelp does {
        message dialog "You clicked Keys"
    }
    window add separator to helpMenu
    window add aboutHelp to helpMenu
    aboutHelp mnemonic 'A'
    aboutHelp ctrl 'A'
    aboutHelp does {
        message dialog "You clicked About"
    }

    window add fileMenu to menuBar
    fileMenu mnemonic 'F'
    window add editMenu to menuBar
    editMenu mnemonic 'E'
    window add helpMenu to menuBar
    helpMenu mnemonic 'H'

    window add menuBar to frame

    frame set size(640, 480)
}
