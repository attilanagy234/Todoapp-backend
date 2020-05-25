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
#include <QtWidgets/QTableWidget>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_TodoWindow
{
public:
    QWidget *widget;
    QLabel *projectnamelabel;
    QLabel *textlabel;
    QLabel *reminderlabel;
    QLineEdit *projectnamelineEdit;
    QLineEdit *textlineEdit;
    QLineEdit *reminderlineEdit;
    QTableWidget *tableWidget;
    QPushButton *savepushButton;
    QPushButton *updatepushButton;
    QPushButton *deletepushButton;

    void setupUi(QWidget *TodoWindow)
    {
        if (TodoWindow->objectName().isEmpty())
            TodoWindow->setObjectName(QString::fromUtf8("TodoWindow"));
        TodoWindow->resize(1021, 564);
        widget = new QWidget(TodoWindow);
        widget->setObjectName(QString::fromUtf8("widget"));
        widget->setGeometry(QRect(0, 0, 1200, 600));
        projectnamelabel = new QLabel(widget);
        projectnamelabel->setObjectName(QString::fromUtf8("projectnamelabel"));
        projectnamelabel->setGeometry(QRect(100, 130, 81, 21));
        textlabel = new QLabel(widget);
        textlabel->setObjectName(QString::fromUtf8("textlabel"));
        textlabel->setGeometry(QRect(100, 180, 41, 21));
        reminderlabel = new QLabel(widget);
        reminderlabel->setObjectName(QString::fromUtf8("reminderlabel"));
        reminderlabel->setGeometry(QRect(100, 230, 61, 21));
        projectnamelineEdit = new QLineEdit(widget);
        projectnamelineEdit->setObjectName(QString::fromUtf8("projectnamelineEdit"));
        projectnamelineEdit->setGeometry(QRect(190, 130, 151, 21));
        textlineEdit = new QLineEdit(widget);
        textlineEdit->setObjectName(QString::fromUtf8("textlineEdit"));
        textlineEdit->setGeometry(QRect(190, 180, 151, 21));
        reminderlineEdit = new QLineEdit(widget);
        reminderlineEdit->setObjectName(QString::fromUtf8("reminderlineEdit"));
        reminderlineEdit->setGeometry(QRect(190, 230, 151, 21));
        tableWidget = new QTableWidget(widget);
        if (tableWidget->columnCount() < 4)
            tableWidget->setColumnCount(4);
        QTableWidgetItem *__qtablewidgetitem = new QTableWidgetItem();
        tableWidget->setHorizontalHeaderItem(0, __qtablewidgetitem);
        QTableWidgetItem *__qtablewidgetitem1 = new QTableWidgetItem();
        tableWidget->setHorizontalHeaderItem(1, __qtablewidgetitem1);
        QTableWidgetItem *__qtablewidgetitem2 = new QTableWidgetItem();
        tableWidget->setHorizontalHeaderItem(2, __qtablewidgetitem2);
        QTableWidgetItem *__qtablewidgetitem3 = new QTableWidgetItem();
        tableWidget->setHorizontalHeaderItem(3, __qtablewidgetitem3);
        tableWidget->setObjectName(QString::fromUtf8("tableWidget"));
        tableWidget->setGeometry(QRect(450, 100, 561, 311));
        savepushButton = new QPushButton(widget);
        savepushButton->setObjectName(QString::fromUtf8("savepushButton"));
        savepushButton->setGeometry(QRect(90, 320, 75, 23));
        updatepushButton = new QPushButton(widget);
        updatepushButton->setObjectName(QString::fromUtf8("updatepushButton"));
        updatepushButton->setGeometry(QRect(190, 320, 75, 23));
        deletepushButton = new QPushButton(widget);
        deletepushButton->setObjectName(QString::fromUtf8("deletepushButton"));
        deletepushButton->setGeometry(QRect(290, 320, 75, 23));

        retranslateUi(TodoWindow);

        QMetaObject::connectSlotsByName(TodoWindow);
    } // setupUi

    void retranslateUi(QWidget *TodoWindow)
    {
        TodoWindow->setWindowTitle(QCoreApplication::translate("TodoWindow", "Form", nullptr));
        projectnamelabel->setText(QCoreApplication::translate("TodoWindow", "Project name:", nullptr));
        textlabel->setText(QCoreApplication::translate("TodoWindow", "Text:", nullptr));
        reminderlabel->setText(QCoreApplication::translate("TodoWindow", "Reminder:", nullptr));
        QTableWidgetItem *___qtablewidgetitem = tableWidget->horizontalHeaderItem(0);
        ___qtablewidgetitem->setText(QCoreApplication::translate("TodoWindow", "id", nullptr));
        QTableWidgetItem *___qtablewidgetitem1 = tableWidget->horizontalHeaderItem(1);
        ___qtablewidgetitem1->setText(QCoreApplication::translate("TodoWindow", "Project name", nullptr));
        QTableWidgetItem *___qtablewidgetitem2 = tableWidget->horizontalHeaderItem(2);
        ___qtablewidgetitem2->setText(QCoreApplication::translate("TodoWindow", "Text", nullptr));
        QTableWidgetItem *___qtablewidgetitem3 = tableWidget->horizontalHeaderItem(3);
        ___qtablewidgetitem3->setText(QCoreApplication::translate("TodoWindow", "Reminder", nullptr));
        savepushButton->setText(QCoreApplication::translate("TodoWindow", "Save", nullptr));
        updatepushButton->setText(QCoreApplication::translate("TodoWindow", "Update", nullptr));
        deletepushButton->setText(QCoreApplication::translate("TodoWindow", "Delete", nullptr));
    } // retranslateUi

};

namespace Ui {
    class TodoWindow: public Ui_TodoWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_TODOWINDOW_H
