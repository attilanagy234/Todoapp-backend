import QtQuick 2.0
import QtQuick.Window 2.1
import QtQuick.Controls 1.2
import QtQuick.Layouts 1.0
import QtQuick.Dialogs 1.0

RowLayout {

    function requestPost()
    {
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        var theUrl = "http://localhost:8080/tasks";
        xmlhttp.open("POST", theUrl);
        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xmlhttp.send(JSON.stringify({ "name": name.text , "description": desc.text, "deadline":deadline.text } ));
        name.text = "";
        desc.text = "";
        deadline.text = "";
    }

    function getData() {
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/tasks";

        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                tasksTableView.clear();
                var test = Object.keys(JSON.parse(xmlhttp.responseText)).length;
                for(var j=0;j<test;j++){
                    var id = JSON.parse(xmlhttp.responseText)[j]["id"];
                    var name = JSON.parse(xmlhttp.responseText)[j]["name"];
                    var description = JSON.parse(xmlhttp.responseText)[j]["description"];
                    var deadline = JSON.parse(xmlhttp.responseText)[j]["deadline"];
//                    var assignee = JSON.parse(xmlhttp.responseText)[j]["assignee"]["name"];
//                    var project = JSON.parse(xmlhttp.responseText)[j]["project"]["name"];

                    var labelsSize;
                    if(JSON.parse(xmlhttp.responseText)[j]["labels"] == null){
                        labelsSize=0;
                    } else {
                        labelsSize = JSON.parse(xmlhttp.responseText)[j]["labels"].length;
                    }
                    var labelString = "";
                    for(var i=0; i<labelsSize; i++) {
                        labelString += String(JSON.parse(xmlhttp.responseText)[j]["labels"][i]["displayValue"])+ " ";
                    }

                    tasksTableView.append({"Id": id, "Name": name, "Description" : description,"Deadline": deadline,
                                           "Label": labelString});
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
        id: tasksTableView

    }
    TableViewColumn {
        role: "Id"
         title: "Id"
        width: 100
    }
       TableViewColumn {
           role: "Name"
            title: "Name"
           width: 100
       }
       TableViewColumn {
              role: "Description"
            title: "Description"
            width: 200
        }
        TableViewColumn {
            role: "Deadline"
            title: "Deadline"
            width: 100
        }
        TableViewColumn {
            role: "Assignee"
            title: "Assignee"
            width: 100
        }
        TableViewColumn {
            role: "Project"
            title: "Project"
            width: 100
        }
        TableViewColumn {
            role: "Label"
            title: "Label"
            width: 100
        }
    }
    ColumnLayout{
        TextField {
          id: name
          placeholderText: qsTr("name")
       }
       TextField {
           id: desc
           placeholderText: qsTr("Description")
       }
        TextField {
            id: deadline
           placeholderText: qsTr("Deadline")
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
//        onClicked: getData()
    }
    Button {
        text: "Load Data"
        onClicked: getData()
    }
    }
}
}
