import QtQuick 2.0
import QtQuick 2.2
import QtQuick.Window 2.1
import QtQuick.Controls 1.2
import QtQuick.Layouts 1.0
import QtQuick.Dialogs 1.0
import QtQuick 2.12

import QtQuick 2.6
import QtQuick.Window 2.2
import QtQuick.Controls 1.3

RowLayout {

    function requestPost()
    {
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        var theUrl = "http://localhost:8080/labels";
        xmlhttp.open("POST", theUrl);
        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xmlhttp.send(JSON.stringify({ "name": labelname.text , "displayValue": labelvalue.text } ));
        labelname.text = "";
        labelvalue.text = "";
    }

    function getData() {
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/labels";

        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                labelTableView.clear();
                var test = Object.keys(JSON.parse(xmlhttp.responseText)).length;
                for(var j=0;j<test;j++){
                    var name = JSON.parse(xmlhttp.responseText)[j]["name"];
                    var value = JSON.parse(xmlhttp.responseText)[j]["displayValue"];
                    var task = JSON.parse(xmlhttp.responseText)[j]["tasks"];

                    var tasksSize;
                    if(JSON.parse(xmlhttp.responseText)[j]["tasks"] == null) {
                        tasksSize = 0;
                    } else{
                        tasksSize = JSON.parse(xmlhttp.responseText)[j]["tasks"].length;
                    }
                    var tasksString = "";
                    for(var i=0; i<tasksSize; i++) {
                        tasksString += String(JSON.parse(xmlhttp.responseText)[j]["tasks"][i]["name"])+ " ";
                    }

                    labelTableView.append({"Name": name, "Value": value, "Tasks": tasksString});
                }
            }
        }
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    }

    SplitView{
        Layout.alignment: parent
        orientation: Qt.Horizontal
    TableView {

        width: 800
        height: 300

        alternatingRowColors: false
        backgroundVisible: true

        model : ListModel {
            id: labelTableView
        }
        TableViewColumn {
            role: "Name"
            title: "Name"
            width: 100
        }
        TableViewColumn {
            role: "Value"
            title: "Value"
            width: 100
        }
        TableViewColumn {
            role: "Tasks"
            title: "Tasks"
            width: 100
        }
    }

    ColumnLayout{
        TextField {
          id: labelname
          placeholderText: qsTr("Label name")
       }
        TextField {
          id: labelvalue
          placeholderText: qsTr("Value")
         }
    }
    ColumnLayout{
    Button {
        text: "Save"
        onClicked: requestPost()
    }
    Button {
        text: "Update"
//        onClicked: getData()
    }
    Button {
        text: "Delete"
//        onClicked:
    }
    Button {
        text: "Load Data"
        onClicked: getData()
    }
}
}
}

