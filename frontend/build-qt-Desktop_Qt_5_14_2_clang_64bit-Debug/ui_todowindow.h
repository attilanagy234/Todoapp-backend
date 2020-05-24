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
#include <QtWidgets/QDialog>

QT_BEGIN_NAMESPACE

class Ui_TodoWindow
{
public:

    void setupUi(QDialog *TodoWindow)
    {
        if (TodoWindow->objectName().isEmpty())
            TodoWindow->setObjectName(QString::fromUtf8("TodoWindow"));
        TodoWindow->resize(1200, 600);

        retranslateUi(TodoWindow);

        QMetaObject::connectSlotsByName(TodoWindow);
    } // setupUi

    void retranslateUi(QDialog *TodoWindow)
    {
        TodoWindow->setWindowTitle(QCoreApplication::translate("TodoWindow", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class TodoWindow: public Ui_TodoWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_TODOWINDOW_H
