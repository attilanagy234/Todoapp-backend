#include "todowindow.h"
#include "ui_todowindow.h"

TodoWindow::TodoWindow(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::TodoWindow)
{
    ui->setupUi(this);
}

TodoWindow::~TodoWindow()
{
    delete ui;
}
