import QtQuick 2.12
import QtQuick.Controls 2.5
import QtQuick.Layouts 1.3

RowLayout {
    property TextField tfEmail: email
    property TextField tfConfirmPassword: confirmPassword
    property TextField tfUserName: username
    property TextField tfPassword: password

    Item {
        Layout.fillWidth: true
        Layout.fillHeight: true
    }

    function requestPost()
    {
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        var theUrl = "http://localhost:8080/register";

        xmlhttp.open("POST", theUrl, true);
        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xmlhttp.send(JSON.stringify({ "name": username.text , "email": email.text, "password": password.text } ));

        successpopup.open();

    }

    ColumnLayout {

        spacing: 20

        Item {
            Layout.fillHeight: true
        }


        TextField {
            id: email
            placeholderText: qsTr("email")
        }

        TextField {
            id: username
            placeholderText: qsTr("username")
        }

        TextField {
            id: password
            placeholderText: qsTr("password")
            echoMode: TextInput.Password
        }

        Button {
            text: "Register"
            Layout.alignment: Qt.AlignRight
            onClicked:  requestPost()

        }


        Item {
            Layout.fillHeight: true
        }
    }

    Item {
        Layout.fillWidth: true
        Layout.fillHeight: true
    }
    Popup {
        id: successpopup
        x: 100
        y: 100
        width: 200
        height: 300
        anchors.centerIn: parent
        modal: true
        focus: true
        padding: 10
        contentItem: Text {
                text: "Successful registration!"
                font.pointSize: 12
                color: "green"
                anchors.centerIn: parent
            }
        closePolicy: Popup.CloseOnEscape | Popup.CloseOnPressOutsideParent
    }

    Popup {
        id: errorpopup
        x: 100
        y: 100
        width: 200
        height: 300
        anchors.centerIn: parent
        modal: true
        focus: true
        padding: 10
        contentItem: Text {
                text: "Failed registration!"
                font.pointSize: 12
                color: "red"
                anchors.centerIn: parent
            }
        closePolicy: Popup.CloseOnEscape | Popup.CloseOnPressOutsideParent
    }
}
