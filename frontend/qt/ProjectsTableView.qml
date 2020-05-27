import QtQuick 2.0
import QtQuick.Window 2.1
import QtQuick.Controls 1.2
import QtQuick.Layouts 1.0
import QtQuick.Dialogs 1.0

RowLayout {

    function requestPost()
    {
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        var theUrl = "http://localhost:8080/projects";
        xmlhttp.open("POST", theUrl);
        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xmlhttp.send(JSON.stringify({ "name": projectname.text , "description": projdesc.text } ));
        projectname.text = "";
        projdesc.text = "";
    }

    function getData() {
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/projects";

        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                projectsTableView.clear();
                var test = Object.keys(JSON.parse(xmlhttp.responseText)).length;
                for(var j=0;j<test;j++){
                    var id = JSON.parse(xmlhttp.responseText)[j]["id"];
                    var name = JSON.parse(xmlhttp.responseText)[j]["name"];
                    var description = JSON.parse(xmlhttp.responseText)[j]["description"];
                    var members = JSON.parse(xmlhttp.responseText)[j]["members"];
                    var tasks = JSON.parse(xmlhttp.responseText)[j]["tasks"];

                    var membersSize;
                    if(JSON.parse(xmlhttp.responseText)[j]["members"] == null) {
                        membersSize = 0;
                    } else{
                        membersSize    = JSON.parse(xmlhttp.responseText)[j]["tasks"].length;
                    }
                    var membersString = "";

                    var tasksSize;
                    if(JSON.parse(xmlhttp.responseText)[j]["tasks"] == null) {
                        tasksSize = 0;
                    } else{
                        tasksSize    = JSON.parse(xmlhttp.responseText)[j]["tasks"].length;
                    }
                    var tasksString = "";
                    for(var i=0; i<membersSize; i++) {
                        membersString += String(JSON.parse(xmlhttp.responseText)[j]["members"][i]["name"])+ " ";
                    }
                    for(var i=0; i<tasksSize; i++) {
                        tasksString += String(JSON.parse(xmlhttp.responseText)[j]["tasks"][i]["name"])+ " ";
                    }

                    projectsTableView.append({"Id": id, "Name": name, "Description" : description});
                }
            }
        }
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    }

    SplitView {
        Layout.alignment: parent
        orientation: Qt.Horizontal

    TableView {
        width: 800
        height: 300

        alternatingRowColors: false
        backgroundVisible: true

    model : ListModel {
        id: projectsTableView
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
        width: 300
    }
    TableViewColumn {
        role: "Members"
        title: "Members"
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
          id: projectname
          placeholderText: qsTr("Project name")
       }
       TextField {
           id: projdesc
           placeholderText: qsTr("Project description")
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
