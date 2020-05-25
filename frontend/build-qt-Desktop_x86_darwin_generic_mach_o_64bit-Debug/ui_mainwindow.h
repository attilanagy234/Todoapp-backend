/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 5.14.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QApplication>
#include <QtWidgets/QFrame>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QFrame *loginFrame;
    QLabel *loginLabel;
    QPushButton *signInPushButton;
    QLineEdit *emailLineEdit;
    QLineEdit *passwordLineEdit;
    QLabel *registerLabel;
    QLineEdit *registerEmailLineEdit;
    QLineEdit *registerPasswordLineEdit;
    QLineEdit *registerPasswordConfLineEdit;
    QPushButton *registerPushButton;
    QToolButton *toolButton;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(1200, 600);
        MainWindow->setStyleSheet(QString::fromUtf8("* {\n"
"	font-family:century gothic;\n"
"	font-size: 24px;\n"
"}\n"
"\n"
"#loginFrame\n"
"{\n"
"	background: #bfbfbf;\n"
"	border-radius: 15px;\n"
"}\n"
"\n"
"\n"
"#signInPushButton\n"
"{\n"
"	background: #70dbdb;\n"
"	border-radius: 15px;\n"
"	color: white;\n"
"	font-size: 18px;\n"
"}\n"
"\n"
"#signInPushButton:hover\n"
"{\n"
"	background: #33cccc;\n"
"}\n"
"\n"
"#registerPushButton\n"
"{\n"
"	background: #70dbdb;\n"
"	border-radius: 15px;\n"
"	color: white;\n"
"	font-size: 18px;\n"
"}\n"
"\n"
"#registerPushButton:hover\n"
"{\n"
"	background: #33cccc;\n"
"}\n"
"\n"
"#toolButton\n"
"{\n"
"	background: #70dbdb;\n"
"	border-radius: 60px;\n"
"}\n"
"#loginLabel\n"
"{\n"
"color: white;\n"
"}\n"
"\n"
"#registerLabel\n"
"{\n"
"color: white;\n"
"}\n"
"\n"
"QLineEdit\n"
"{\n"
"background: transparent;\n"
"border: none;\n"
"color: white;\n"
"font-size: 20px;\n"
"border-bottom:  1px solid white;\n"
"}\n"
"\n"
"#usernameLineEdit:focus\n"
"{\n"
"   outline-color: black;\n"
"}"));
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        loginFrame = new QFrame(centralwidget);
        loginFrame->setObjectName(QString::fromUtf8("loginFrame"));
        loginFrame->setGeometry(QRect(100, 110, 1001, 401));
        loginFrame->setFrameShape(QFrame::StyledPanel);
        loginFrame->setFrameShadow(QFrame::Raised);
        loginLabel = new QLabel(loginFrame);
        loginLabel->setObjectName(QString::fromUtf8("loginLabel"));
        loginLabel->setGeometry(QRect(210, 30, 61, 41));
        signInPushButton = new QPushButton(loginFrame);
        signInPushButton->setObjectName(QString::fromUtf8("signInPushButton"));
        signInPushButton->setGeometry(QRect(140, 310, 201, 41));
        emailLineEdit = new QLineEdit(loginFrame);
        emailLineEdit->setObjectName(QString::fromUtf8("emailLineEdit"));
        emailLineEdit->setGeometry(QRect(110, 100, 271, 31));
        emailLineEdit->setFocusPolicy(Qt::StrongFocus);
        passwordLineEdit = new QLineEdit(loginFrame);
        passwordLineEdit->setObjectName(QString::fromUtf8("passwordLineEdit"));
        passwordLineEdit->setGeometry(QRect(110, 170, 271, 31));
        passwordLineEdit->setEchoMode(QLineEdit::Password);
        registerLabel = new QLabel(loginFrame);
        registerLabel->setObjectName(QString::fromUtf8("registerLabel"));
        registerLabel->setGeometry(QRect(710, 30, 91, 41));
        registerEmailLineEdit = new QLineEdit(loginFrame);
        registerEmailLineEdit->setObjectName(QString::fromUtf8("registerEmailLineEdit"));
        registerEmailLineEdit->setGeometry(QRect(610, 100, 271, 31));
        registerEmailLineEdit->setFocusPolicy(Qt::StrongFocus);
        registerPasswordLineEdit = new QLineEdit(loginFrame);
        registerPasswordLineEdit->setObjectName(QString::fromUtf8("registerPasswordLineEdit"));
        registerPasswordLineEdit->setGeometry(QRect(610, 170, 271, 31));
        registerPasswordLineEdit->setEchoMode(QLineEdit::Password);
        registerPasswordConfLineEdit = new QLineEdit(loginFrame);
        registerPasswordConfLineEdit->setObjectName(QString::fromUtf8("registerPasswordConfLineEdit"));
        registerPasswordConfLineEdit->setGeometry(QRect(610, 240, 271, 31));
        registerPasswordConfLineEdit->setEchoMode(QLineEdit::Password);
        registerPushButton = new QPushButton(loginFrame);
        registerPushButton->setObjectName(QString::fromUtf8("registerPushButton"));
        registerPushButton->setGeometry(QRect(650, 310, 201, 41));
        toolButton = new QToolButton(centralwidget);
        toolButton->setObjectName(QString::fromUtf8("toolButton"));
        toolButton->setGeometry(QRect(520, 30, 141, 131));
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/images/user.png"), QSize(), QIcon::Normal, QIcon::Off);
        toolButton->setIcon(icon);
        toolButton->setIconSize(QSize(60, 60));
        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 1200, 22));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        loginLabel->setText(QCoreApplication::translate("MainWindow", "Log In", nullptr));
        signInPushButton->setText(QCoreApplication::translate("MainWindow", "Sign In", nullptr));
        emailLineEdit->setText(QString());
        emailLineEdit->setPlaceholderText(QCoreApplication::translate("MainWindow", "email", nullptr));
        passwordLineEdit->setText(QString());
        passwordLineEdit->setPlaceholderText(QCoreApplication::translate("MainWindow", "password", nullptr));
        registerLabel->setText(QCoreApplication::translate("MainWindow", "Register", nullptr));
        registerEmailLineEdit->setText(QString());
        registerEmailLineEdit->setPlaceholderText(QCoreApplication::translate("MainWindow", "email", nullptr));
        registerPasswordLineEdit->setText(QString());
        registerPasswordLineEdit->setPlaceholderText(QCoreApplication::translate("MainWindow", "password", nullptr));
        registerPasswordConfLineEdit->setText(QString());
        registerPasswordConfLineEdit->setPlaceholderText(QCoreApplication::translate("MainWindow", "confirm password", nullptr));
        registerPushButton->setText(QCoreApplication::translate("MainWindow", "Register", nullptr));
        toolButton->setText(QString());
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
