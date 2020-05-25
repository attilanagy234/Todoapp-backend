#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QMessageBox>
#include "todowindow.h"
#include <QTableWidget>

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
    todoWindow = new TodoWindow();
    todoWindow->setWindowTitle("Todoz");
    todoWindow->setFixedSize(1200,600);
//    this->hide();
    todoWindow->show();
}
