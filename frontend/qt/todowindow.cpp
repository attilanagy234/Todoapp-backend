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

void TodoWindow::on_savepushButton_clicked()
{
    QTableWidgetItem *project = new QTableWidgetItem();
    QTableWidgetItem *text = new QTableWidgetItem();
    QTableWidgetItem *reminder = new QTableWidgetItem();

    project->setText(ui->projectnamelineEdit->text());
    text->setText(ui->textlineEdit->text());
    reminder->setText(ui->reminderlineEdit->text());

    int insertRow = ui->tableWidget->rowCount();
    ui->tableWidget->insertRow(insertRow);

    ui->tableWidget->setItem(insertRow, 1, project);
    ui->tableWidget->setItem(project->row(), 2, text);
    ui->tableWidget->setItem(text->row(), 3, reminder);
}
