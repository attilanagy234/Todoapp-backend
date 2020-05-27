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

    function requestPost()
    {
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        var theUrl = "http://localhost:8080/login";

        xmlhttp.open("POST", theUrl, true);
        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xmlhttp.send(JSON.stringify({ "name": username.text , "email": email.text, "password": password.text } ));

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
                stackView.replace("qrc:/ToDoTab.qml")
                requestPost()
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
