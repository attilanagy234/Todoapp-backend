#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QMessageBox>
#include "todowindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

}

MainWindow::~MainWindow()
{
    delete ui;
}



void MainWindow::on_signInPushButton_clicked()
{
//    TodoWindow todoWindow;
//    todoWindow.setModal(true);
//    todoWindow.exec();
    todoWindow = new TodoWindow();
    todoWindow->setWindowTitle("Todoz");
    todoWindow->setFixedSize(1200,600);
    this->hide();
    todoWindow->show();

}
