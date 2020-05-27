import QtQuick 2.12
import QtQuick.Controls 1.4 as C1
import QtQuick.Controls 2.5
import QtQuick.Layouts 1.12
import QtQuick 2.0
import QtQuick.Window 2.1
import QtQuick.Controls 1.2
import QtQuick.Layouts 1.0
import QtQuick.Dialogs 1.0

ApplicationWindow {
    visible: true
    width: 1200
    height: 900
    title: qsTr("ToDoList")

    StackView {
        anchors.fill: parent
        id: stackView
        initialItem:
            Qt.resolvedUrl("qrc:/LoginRegisterTab.qml")
    }

}

