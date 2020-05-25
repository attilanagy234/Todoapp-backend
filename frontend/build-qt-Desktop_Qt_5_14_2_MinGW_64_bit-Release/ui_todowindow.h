/********************************************************************************
** Form generated from reading UI file 'todowindow.ui'
**
** Created by: Qt User Interface Compiler version 5.14.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_TODOWINDOW_H
#define UI_TODOWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QTableWidget>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_TodoWindow
{
public:
    QWidget *widget;
    QPushButton *signOutpushButton;
    QTabWidget *tabWidget;
    QWidget *tab;
    QLabel *projectnamelabel;
    QLineEdit *projectnamelineEdit;
    QLabel *textlabel;
    QLineEdit *textlineEdit;
    QPushButton *projectSavepushButton;
    QPushButton *projectUpdatepushButton;
    QPushButton *projectDeletepushButton;
    QTableWidget *tableWidget;
    QPushButton *loadDatapushButton_1;
    QWidget *tab_3;
    QTableWidget *tableWidget_2;
    QLabel *labelnamelabel;
    QLineEdit *labelnamelineEdit;
    QPushButton *labelSavepushButton;
    QPushButton *labelUpdatepushButton;
    QPushButton *labelDeletepushButton;
    QPushButton *loadDatapushButton_2;
    QWidget *tab_2;
    QTableWidget *tableWidget_3;
    QLabel *tasknamelabel;
    QLabel *taskdesclabel;
    QLabel *projectnamelabel_4;
    QLabel *projectnamelabel_5;
    QLabel *projectnamelabel_6;
    QLineEdit *tasknamelineEdit;
    QLineEdit *taskDesclineEdit;
    QLineEdit *taskDeadlinelineEdit;
    QLineEdit *taskprojectlineEdit;
    QLineEdit *tasklabellineEdit;
    QPushButton *taskSavepushButton;
    QPushButton *taskUpdatepushButton;
    QPushButton *taskDeletepushButton;
    QPushButton *loadDatapushButton_3;

    void setupUi(QWidget *TodoWindow)
    {
        if (TodoWindow->objectName().isEmpty())
            TodoWindow->setObjectName(QString::fromUtf8("TodoWindow"));
        TodoWindow->resize(1021, 564);
        widget = new QWidget(TodoWindow);
        widget->setObjectName(QString::fromUtf8("widget"));
        widget->setGeometry(QRect(0, 0, 1200, 600));
        signOutpushButton = new QPushButton(widget);
        signOutpushButton->setObjectName(QString::fromUtf8("signOutpushButton"));
        signOutpushButton->setGeometry(QRect(830, 520, 111, 31));
        tabWidget = new QTabWidget(widget);
        tabWidget->setObjectName(QString::fromUtf8("tabWidget"));
        tabWidget->setGeometry(QRect(9, 9, 1011, 501));
        tab = new QWidget();
        tab->setObjectName(QString::fromUtf8("tab"));
        projectnamelabel = new QLabel(tab);
        projectnamelabel->setObjectName(QString::fromUtf8("projectnamelabel"));
        projectnamelabel->setGeometry(QRect(120, 140, 81, 21));
        projectnamelineEdit = new QLineEdit(tab);
        projectnamelineEdit->setObjectName(QString::fromUtf8("projectnamelineEdit"));
        projectnamelineEdit->setGeometry(QRect(290, 140, 151, 21));
        textlabel = new QLabel(tab);
        textlabel->setObjectName(QString::fromUtf8("textlabel"));
        textlabel->setGeometry(QRect(120, 170, 141, 21));
        textlineEdit = new QLineEdit(tab);
        textlineEdit->setObjectName(QString::fromUtf8("textlineEdit"));
        textlineEdit->setGeometry(QRect(290, 170, 151, 21));
        projectSavepushButton = new QPushButton(tab);
        projectSavepushButton->setObjectName(QString::fromUtf8("projectSavepushButton"));
        projectSavepushButton->setGeometry(QRect(130, 220, 75, 23));
        projectUpdatepushButton = new QPushButton(tab);
        projectUpdatepushButton->setObjectName(QString::fromUtf8("projectUpdatepushButton"));
        projectUpdatepushButton->setGeometry(QRect(220, 220, 75, 23));
        projectDeletepushButton = new QPushButton(tab);
        projectDeletepushButton->setObjectName(QString::fromUtf8("projectDeletepushButton"));
        projectDeletepushButton->setGeometry(QRect(310, 220, 75, 23));
        tableWidget = new QTableWidget(tab);
        if (tableWidget->columnCount() < 3)
            tableWidget->setColumnCount(3);
        QTableWidgetItem *__qtablewidgetitem = new QTableWidgetItem();
        tableWidget->setHorizontalHeaderItem(0, __qtablewidgetitem);
        QTableWidgetItem *__qtablewidgetitem1 = new QTableWidgetItem();
        tableWidget->setHorizontalHeaderItem(1, __qtablewidgetitem1);
        QTableWidgetItem *__qtablewidgetitem2 = new QTableWidgetItem();
        tableWidget->setHorizontalHeaderItem(2, __qtablewidgetitem2);
        tableWidget->setObjectName(QString::fromUtf8("tableWidget"));
        tableWidget->setGeometry(QRect(640, 30, 301, 401));
        loadDatapushButton_1 = new QPushButton(tab);
        loadDatapushButton_1->setObjectName(QString::fromUtf8("loadDatapushButton_1"));
        loadDatapushButton_1->setGeometry(QRect(530, 400, 75, 23));
        tabWidget->addTab(tab, QString());
        tab_3 = new QWidget();
        tab_3->setObjectName(QString::fromUtf8("tab_3"));
        tableWidget_2 = new QTableWidget(tab_3);
        if (tableWidget_2->columnCount() < 2)
            tableWidget_2->setColumnCount(2);
        QTableWidgetItem *__qtablewidgetitem3 = new QTableWidgetItem();
        tableWidget_2->setHorizontalHeaderItem(0, __qtablewidgetitem3);
        QTableWidgetItem *__qtablewidgetitem4 = new QTableWidgetItem();
        tableWidget_2->setHorizontalHeaderItem(1, __qtablewidgetitem4);
        tableWidget_2->setObjectName(QString::fromUtf8("tableWidget_2"));
        tableWidget_2->setGeometry(QRect(680, 40, 201, 401));
        labelnamelabel = new QLabel(tab_3);
        labelnamelabel->setObjectName(QString::fromUtf8("labelnamelabel"));
        labelnamelabel->setGeometry(QRect(240, 150, 81, 21));
        labelnamelineEdit = new QLineEdit(tab_3);
        labelnamelineEdit->setObjectName(QString::fromUtf8("labelnamelineEdit"));
        labelnamelineEdit->setGeometry(QRect(370, 150, 151, 21));
        labelSavepushButton = new QPushButton(tab_3);
        labelSavepushButton->setObjectName(QString::fromUtf8("labelSavepushButton"));
        labelSavepushButton->setGeometry(QRect(240, 210, 75, 23));
        labelUpdatepushButton = new QPushButton(tab_3);
        labelUpdatepushButton->setObjectName(QString::fromUtf8("labelUpdatepushButton"));
        labelUpdatepushButton->setGeometry(QRect(340, 210, 75, 23));
        labelDeletepushButton = new QPushButton(tab_3);
        labelDeletepushButton->setObjectName(QString::fromUtf8("labelDeletepushButton"));
        labelDeletepushButton->setGeometry(QRect(440, 210, 75, 23));
        loadDatapushButton_2 = new QPushButton(tab_3);
        loadDatapushButton_2->setObjectName(QString::fromUtf8("loadDatapushButton_2"));
        loadDatapushButton_2->setGeometry(QRect(570, 420, 75, 23));
        tabWidget->addTab(tab_3, QString());
        tab_2 = new QWidget();
        tab_2->setObjectName(QString::fromUtf8("tab_2"));
        tableWidget_3 = new QTableWidget(tab_2);
        if (tableWidget_3->columnCount() < 6)
            tableWidget_3->setColumnCount(6);
        QTableWidgetItem *__qtablewidgetitem5 = new QTableWidgetItem();
        tableWidget_3->setHorizontalHeaderItem(0, __qtablewidgetitem5);
        QTableWidgetItem *__qtablewidgetitem6 = new QTableWidgetItem();
        tableWidget_3->setHorizontalHeaderItem(1, __qtablewidgetitem6);
        QTableWidgetItem *__qtablewidgetitem7 = new QTableWidgetItem();
        tableWidget_3->setHorizontalHeaderItem(2, __qtablewidgetitem7);
        QTableWidgetItem *__qtablewidgetitem8 = new QTableWidgetItem();
        tableWidget_3->setHorizontalHeaderItem(3, __qtablewidgetitem8);
        QTableWidgetItem *__qtablewidgetitem9 = new QTableWidgetItem();
        tableWidget_3->setHorizontalHeaderItem(4, __qtablewidgetitem9);
        QTableWidgetItem *__qtablewidgetitem10 = new QTableWidgetItem();
        tableWidget_3->setHorizontalHeaderItem(5, __qtablewidgetitem10);
        tableWidget_3->setObjectName(QString::fromUtf8("tableWidget_3"));
        tableWidget_3->setGeometry(QRect(360, 40, 601, 411));
        tasknamelabel = new QLabel(tab_2);
        tasknamelabel->setObjectName(QString::fromUtf8("tasknamelabel"));
        tasknamelabel->setGeometry(QRect(30, 100, 91, 21));
        taskdesclabel = new QLabel(tab_2);
        taskdesclabel->setObjectName(QString::fromUtf8("taskdesclabel"));
        taskdesclabel->setGeometry(QRect(30, 140, 91, 21));
        projectnamelabel_4 = new QLabel(tab_2);
        projectnamelabel_4->setObjectName(QString::fromUtf8("projectnamelabel_4"));
        projectnamelabel_4->setGeometry(QRect(30, 180, 91, 21));
        projectnamelabel_5 = new QLabel(tab_2);
        projectnamelabel_5->setObjectName(QString::fromUtf8("projectnamelabel_5"));
        projectnamelabel_5->setGeometry(QRect(30, 220, 91, 21));
        projectnamelabel_6 = new QLabel(tab_2);
        projectnamelabel_6->setObjectName(QString::fromUtf8("projectnamelabel_6"));
        projectnamelabel_6->setGeometry(QRect(30, 260, 91, 21));
        tasknamelineEdit = new QLineEdit(tab_2);
        tasknamelineEdit->setObjectName(QString::fromUtf8("tasknamelineEdit"));
        tasknamelineEdit->setGeometry(QRect(170, 100, 151, 21));
        taskDesclineEdit = new QLineEdit(tab_2);
        taskDesclineEdit->setObjectName(QString::fromUtf8("taskDesclineEdit"));
        taskDesclineEdit->setGeometry(QRect(170, 140, 151, 21));
        taskDeadlinelineEdit = new QLineEdit(tab_2);
        taskDeadlinelineEdit->setObjectName(QString::fromUtf8("taskDeadlinelineEdit"));
        taskDeadlinelineEdit->setGeometry(QRect(170, 180, 151, 21));
        taskprojectlineEdit = new QLineEdit(tab_2);
        taskprojectlineEdit->setObjectName(QString::fromUtf8("taskprojectlineEdit"));
        taskprojectlineEdit->setGeometry(QRect(170, 220, 151, 21));
        tasklabellineEdit = new QLineEdit(tab_2);
        tasklabellineEdit->setObjectName(QString::fromUtf8("tasklabellineEdit"));
        tasklabellineEdit->setGeometry(QRect(170, 260, 151, 21));
        taskSavepushButton = new QPushButton(tab_2);
        taskSavepushButton->setObjectName(QString::fromUtf8("taskSavepushButton"));
        taskSavepushButton->setGeometry(QRect(40, 320, 75, 23));
        taskUpdatepushButton = new QPushButton(tab_2);
        taskUpdatepushButton->setObjectName(QString::fromUtf8("taskUpdatepushButton"));
        taskUpdatepushButton->setGeometry(QRect(140, 320, 75, 23));
        taskDeletepushButton = new QPushButton(tab_2);
        taskDeletepushButton->setObjectName(QString::fromUtf8("taskDeletepushButton"));
        taskDeletepushButton->setGeometry(QRect(240, 320, 75, 23));
        loadDatapushButton_3 = new QPushButton(tab_2);
        loadDatapushButton_3->setObjectName(QString::fromUtf8("loadDatapushButton_3"));
        loadDatapushButton_3->setGeometry(QRect(260, 430, 75, 23));
        tabWidget->addTab(tab_2, QString());

        retranslateUi(TodoWindow);

        tabWidget->setCurrentIndex(2);


        QMetaObject::connectSlotsByName(TodoWindow);
    } // setupUi

    void retranslateUi(QWidget *TodoWindow)
    {
        TodoWindow->setWindowTitle(QCoreApplication::translate("TodoWindow", "Form", nullptr));
        signOutpushButton->setText(QCoreApplication::translate("TodoWindow", "Sign Out", nullptr));
        projectnamelabel->setText(QCoreApplication::translate("TodoWindow", "Project name:", nullptr));
        textlabel->setText(QCoreApplication::translate("TodoWindow", "Project description:", nullptr));
        projectSavepushButton->setText(QCoreApplication::translate("TodoWindow", "Save", nullptr));
        projectUpdatepushButton->setText(QCoreApplication::translate("TodoWindow", "Update", nullptr));
        projectDeletepushButton->setText(QCoreApplication::translate("TodoWindow", "Delete", nullptr));
        QTableWidgetItem *___qtablewidgetitem = tableWidget->horizontalHeaderItem(0);
        ___qtablewidgetitem->setText(QCoreApplication::translate("TodoWindow", "id", nullptr));
        QTableWidgetItem *___qtablewidgetitem1 = tableWidget->horizontalHeaderItem(1);
        ___qtablewidgetitem1->setText(QCoreApplication::translate("TodoWindow", "Name", nullptr));
        QTableWidgetItem *___qtablewidgetitem2 = tableWidget->horizontalHeaderItem(2);
        ___qtablewidgetitem2->setText(QCoreApplication::translate("TodoWindow", "Description", nullptr));
        loadDatapushButton_1->setText(QCoreApplication::translate("TodoWindow", "Load Data", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(tab), QCoreApplication::translate("TodoWindow", "Projects", nullptr));
        QTableWidgetItem *___qtablewidgetitem3 = tableWidget_2->horizontalHeaderItem(0);
        ___qtablewidgetitem3->setText(QCoreApplication::translate("TodoWindow", "id", nullptr));
        QTableWidgetItem *___qtablewidgetitem4 = tableWidget_2->horizontalHeaderItem(1);
        ___qtablewidgetitem4->setText(QCoreApplication::translate("TodoWindow", "Name", nullptr));
        labelnamelabel->setText(QCoreApplication::translate("TodoWindow", "Label name:", nullptr));
        labelSavepushButton->setText(QCoreApplication::translate("TodoWindow", "Save", nullptr));
        labelUpdatepushButton->setText(QCoreApplication::translate("TodoWindow", "Update", nullptr));
        labelDeletepushButton->setText(QCoreApplication::translate("TodoWindow", "Delete", nullptr));
        loadDatapushButton_2->setText(QCoreApplication::translate("TodoWindow", "Load Data", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(tab_3), QCoreApplication::translate("TodoWindow", "Labels", nullptr));
        QTableWidgetItem *___qtablewidgetitem5 = tableWidget_3->horizontalHeaderItem(0);
        ___qtablewidgetitem5->setText(QCoreApplication::translate("TodoWindow", "id", nullptr));
        QTableWidgetItem *___qtablewidgetitem6 = tableWidget_3->horizontalHeaderItem(1);
        ___qtablewidgetitem6->setText(QCoreApplication::translate("TodoWindow", "Name", nullptr));
        QTableWidgetItem *___qtablewidgetitem7 = tableWidget_3->horizontalHeaderItem(2);
        ___qtablewidgetitem7->setText(QCoreApplication::translate("TodoWindow", "Description", nullptr));
        QTableWidgetItem *___qtablewidgetitem8 = tableWidget_3->horizontalHeaderItem(3);
        ___qtablewidgetitem8->setText(QCoreApplication::translate("TodoWindow", "Deadline", nullptr));
        QTableWidgetItem *___qtablewidgetitem9 = tableWidget_3->horizontalHeaderItem(4);
        ___qtablewidgetitem9->setText(QCoreApplication::translate("TodoWindow", "Project", nullptr));
        QTableWidgetItem *___qtablewidgetitem10 = tableWidget_3->horizontalHeaderItem(5);
        ___qtablewidgetitem10->setText(QCoreApplication::translate("TodoWindow", "Label", nullptr));
        tasknamelabel->setText(QCoreApplication::translate("TodoWindow", "Name:", nullptr));
        taskdesclabel->setText(QCoreApplication::translate("TodoWindow", "Description:", nullptr));
        projectnamelabel_4->setText(QCoreApplication::translate("TodoWindow", "Deadline:", nullptr));
        projectnamelabel_5->setText(QCoreApplication::translate("TodoWindow", "Project:", nullptr));
        projectnamelabel_6->setText(QCoreApplication::translate("TodoWindow", "Label:", nullptr));
        taskSavepushButton->setText(QCoreApplication::translate("TodoWindow", "Save", nullptr));
        taskUpdatepushButton->setText(QCoreApplication::translate("TodoWindow", "Update", nullptr));
        taskDeletepushButton->setText(QCoreApplication::translate("TodoWindow", "Delete", nullptr));
        loadDatapushButton_3->setText(QCoreApplication::translate("TodoWindow", "Load Data", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(tab_2), QCoreApplication::translate("TodoWindow", "Tasks", nullptr));
    } // retranslateUi

};

namespace Ui {
    class TodoWindow: public Ui_TodoWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_TODOWINDOW_H
