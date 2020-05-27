import QtQuick 2.12
import QtQuick.Controls 2.5
import QtQuick.Layouts 1.12

ColumnLayout {
    TabBar {
        id: bar
        Layout.fillWidth: true
        TabButton {
            text: qsTr("login")
            width: implicitWidth
        }
        TabButton {
            text: qsTr("register")
            width: implicitWidth
        }
    }

    StackLayout {
        width: parent.width
        currentIndex: bar.currentIndex
        LoginForm {}
        RegisterForm {}

    }
}

