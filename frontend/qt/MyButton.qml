import QtQuick 2.12
import QtQuick.Controls 2.5

Button {
    contentItem: Text {
            text: parent.text
            color: skinController.fontColor
            horizontalAlignment: Text.AlignHCenter
            verticalAlignment: Text.AlignVCenter
            elide: Text.ElideRight
            opacity: enabled ? 1 : 0.3
        }

    background: Rectangle {
        implicitWidth: 100
        implicitHeight: 40
        opacity: enabled ? 1 : 0.3
        color: skinController.bgColor
        border.color: skinController.fontColor
        border.width: 1
        radius: 8
    }
}
