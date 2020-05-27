import QtQuick 2.12
import QtQuick.Controls 2.5
import QtQuick.Layouts 1.3

RowLayout {
    property TextField tfUserName: userName
    property TextField tfPassword: password

    Item {
        Layout.fillWidth: true
        Layout.fillHeight: true
    }


    ColumnLayout {

        spacing: 20

        Item {
            Layout.fillHeight: true
        }


        TextField {
            id: userName
            placeholderText: qsTr("username")
        }


        TextField {
            id: password
            placeholderText: qsTr("password")
            echoMode: TextInput.Password
        }

        Button {
            text: "Login"
            Layout.alignment: Qt.AlignRight
            onClicked: {
                pageLoader.source = "ToDoTab.qml"

            }
        }


        Item {
            Layout.fillHeight: true
        }
    }

    Item {
        Layout.fillWidth: true
        Layout.fillHeight: true
    }
}
