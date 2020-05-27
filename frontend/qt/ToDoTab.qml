import QtQuick 2.12
import QtQuick.Controls 2.5
import QtQuick.Layouts 1.12
import QtQuick 2.0
import QtQuick.Window 2.1
import QtQuick.Controls 1.2
import QtQuick.Layouts 1.0
import QtQuick.Dialogs 1.0


    ColumnLayout {
        SplitView {
              Layout.alignment: parent
              orientation: Qt.Vertical

            ProjectsTableView{}
           LabelsTableView {}
           TasksTableView {}
         }

    }

